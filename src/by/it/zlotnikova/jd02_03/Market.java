package by.it.zlotnikova.jd02_03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    static Map<String, Double> goods;

    public static void main(String[] args) {

        goods = createGoodsList();
        System.out.println("xxx The market opens xxx");
        List<Thread> actorList = new LinkedList<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int cashierNumber = 2;
        for (int i = 1; i <= cashierNumber; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        while (!Dispatcher.planComplete()) {
            int counter = Utils.random(2);
            for (int j = 0; j <= counter; j++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    actorList.add(buyer);
                    buyer.start();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        actorList.forEach(actor -> {
            try {
                actor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            Thread.yield();
        }
        System.out.println("xxx The market closes xxx");
    }

    private static Map<String, Double> createGoodsList() {
        Map<String, Double> goods = new HashMap<>();
        goods.put("bread", 2.0);
        goods.put("butter", 6.0);
        goods.put("milk", 3.0);
        goods.put("sugar", 4.0);
        goods.put("meat", 8.0);
        goods.put("fish", 7.0);
        goods.put("potatoes", 1.0);
        goods.put("cookies", 5.0);
        return goods;
    }
}