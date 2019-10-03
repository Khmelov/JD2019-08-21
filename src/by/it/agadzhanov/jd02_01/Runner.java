package by.it.agadzhanov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) {

        int totalBuyers = 0;
        System.out.println("Магазин открылся");

        //В течение 120 секунд
        for (int i = 0; i < 120; i++) {
            //Сгенерировать число покупателей от 0 до 2
            int buyersEntered = Util.randomUpTo(2);

            //Создать объект класса Buyer для каждого покупателя, записать его в ArrayList, стартовать его поток
            for (int j = 1; j <= buyersEntered; j++) {
                totalBuyers++;
                Buyer buyer = new Buyer(totalBuyers);
                buyerList.add(buyer);
                buyer.start();
            }

            //Приостановить выполнение main пока не вышли последние покупатели, чтобы магазин не закрылся
            if (i == 119) {
                preventFromClosing();
            }

            //Ожидать секунду до появления следующих возможных покупателей (кроме последней секунды)
            if (i < 119) {
                try {
                    Util.sleepAccelerated(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main: ожидание завершено некорректно!");
                }
            }
        }

        System.out.println("Магазин закрылся");
    }

    private static void preventFromClosing() {
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при попытке приостановить main с помощью метода join()!");
            }
        }
    }
}
