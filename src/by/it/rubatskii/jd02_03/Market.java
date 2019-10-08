package by.it.rubatskii.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Market {

    private static List<Thread> buyersList = new ArrayList<>();

    public static void main (String[] args) {

        System.out.println("Market opened");

        ExecutorService cashierPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= Dispatcher.MAX_CASHIERS; i++) {
            cashierPool.execute(new Cashier());
        }
        while (!Dispatcher.planComplete()) {
            int buyersEntered = Util.randomUpTo(2);

            for (int j = 1; j <= buyersEntered; j++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    buyersList.add(buyer);
                    buyer.start();
                }
            }


                Util.sleepAccelerated(1000);
            }

        preventFromClosing();
        cashierPool.shutdown();
        while (!cashierPool.isTerminated()) {
            Util.sleepAccelerated(1000);
        }
        System.out.println("Market closed");
    }

    private static void preventFromClosing() {
        for (Thread buyer : buyersList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
            }
        }
    }
}
