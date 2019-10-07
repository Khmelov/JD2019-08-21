package by.it.yuntsevich.jd02_03;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        int numberBuyers = 0;
        System.out.println("Магазин открыт");

        List<Thread> actorList = new ArrayList<>(200);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            executor.execute(cashier);
        }

        generateBuyers(numberBuyers, actorList);

        for (Thread thread : actorList)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.shutdown();
            while(!executor.isTerminated()){
                Util.sleep(1);
            }
        System.out.println("Магазин закрыт");
    }


    private static void generateBuyers(int numberBuyers, List<Thread> actorList) {
        while (!Dispathcher.planComplete()) {
            int countBuyers = Util.random(2);
            for (int i = 0; i < countBuyers; i++) {
                if (!Dispathcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyers);
                    if (numberBuyers % 4 == 0) {
                        buyer.setPensioneer(true);
                    }
                    actorList.add(buyer);
                    buyer.start();
                }
                Util.sleep(1000);
            }

        }
    }
}

