package by.it.agadzhanov.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static List<Thread> buyersList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            main1(args);
            Dispatcher.resetBuyerCount();
            Dispatcher.resetCashierCount();
            Dispatcher.resetTotalRevenue();
            Dispatcher.resetCashierRevenueMap();
        }
    }

    public static void main1(String[] args) {

        System.out.println("Магазин открылся");

        ExecutorService cashierPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= Dispatcher.MAX_CASHIERS; i++) {
            cashierPool.execute(new Cashier());
        }

        //В течение 120 секунд
        while (!Dispatcher.planComplete()) {
            //Сгенерировать число покупателей от 0 до 2
            int buyersEntered = Util.randomUpTo(2);

            //Создать объект класса Buyer для каждого покупателя, записать его в ArrayList, стартовать его поток
            for (int j = 1; j <= buyersEntered; j++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    buyersList.add(buyer);
                    buyer.start();
                }
            }

            //Подождать одну секунду
            Util.sleepAccelerated(1000);
        }

        //Не закрывать магазин, пока не вышли последние покупатели
        preventFromClosing();

        //Отключить пул кассиров
        cashierPool.shutdown();
        while (!cashierPool.isTerminated()) {              //Для чего именно нужен этот блок?
            Util.sleepAccelerated(1000);
        }

        System.out.println("Магазин закрылся");
    }

    private static void preventFromClosing() {
        for (Thread buyer : buyersList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при попытке приостановить main с помощью метода join()!");
            }
        }
    }
}
