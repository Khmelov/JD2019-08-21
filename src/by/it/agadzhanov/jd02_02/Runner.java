package by.it.agadzhanov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Thread> peopleList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            main1(args);
            Dispatcher.reset();
        }
    }

    public static void main1(String[] args) {

        System.out.println("Магазин открылся");

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            peopleList.add(thread);
            Dispatcher.cashierList.add(cashier);
            thread.start();
        }

        //В течение 120 секунд
        while (!Dispatcher.planComplete()) {
            //Сгенерировать число покупателей от 0 до 2
            int buyersEntered = Util.randomUpTo(2);

            //Создать объект класса Buyer для каждого покупателя, записать его в ArrayList, стартовать его поток
            for (int j = 1; j <= buyersEntered; j++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    peopleList.add(buyer);
                    buyer.start();
                }
            }

            //Dispatcher.setCashierNumber();

            try {
                Util.sleepAccelerated(1000);
            } catch (InterruptedException e) {
                System.out.println("Main: ошибка при вызове sleep()!");
            }
        }

        //Не закрывать магазин, пока не вышли последние покупатели
        preventFromClosing();
        System.out.println("Магазин закрылся");
    }

    private static void preventFromClosing() {
        for (Thread person : peopleList) {
            try {
                person.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при попытке приостановить main с помощью метода join()!");
            }
        }
    }
}
