package by.it.boytsov.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static List<Thread> peopleList = new ArrayList<>();

    public static void main (String[] args) throws InterruptedException {
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
                    peopleList.add(buyer);
                    buyer.start();
                }

            }
                Util.sleep(1000);
        }
        preventFromClosing();
        cashierPool.shutdown();
        while (!cashierPool.isTerminated()) {

            Util.sleep(1000);
        }
        System.out.println("Market closed");
    }


        private static void preventFromClosing() {
            for (Thread person : peopleList) {
                try {
                    person.join();
                } catch (InterruptedException e) {
                }
            }
        }
}

