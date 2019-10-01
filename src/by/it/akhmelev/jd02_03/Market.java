package by.it.akhmelev.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {


//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 500; i++) {
//            Dispatcher.reset();
//            main2(args);
//        }
//    }

    public static void main2(String[] args) throws InterruptedException {
        System.out.println("Market opened");

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        List<Thread> actorList = new ArrayList<>(200);
        while (!Dispatcher.planComplete()) {
            int max = Util.random(2);
            for (int i = 0; i < max; i++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    actorList.add(buyer);
                    buyer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread actor : actorList) {
            actor.join();
        }
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            Thread.yield();
        }
        System.out.println("Market closed");
    }


}
