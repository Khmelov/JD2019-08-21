package by.it.zlotnikova.jd02_01;

import java.util.*;

public class Market {

    static Map<String, Double> goods;

    public static void main(String[] args) {

        goods = getGoodsList();

        int time = 120; //seconds; a period time when the market is open
        int buyerNumber = 1;
        List<Buyer> buyerList = new LinkedList<>();

        System.out.println("xxx The market opens xxx");

        for (int i = 0; i < time; i++) {
            int counter = Utils.random(2);
            for (int j = 0; j <= counter; j++) {
                Buyer buyer = new Buyer("Buyer " + buyerNumber);
                buyer.start();
                buyerList.add(buyer);
                buyerNumber++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // check number of buyers in the market
//        int countBuyers = 0;
//        Iterator<Buyer> it = buyerList.iterator();
//        while (it.hasNext()) {
//            if (it.next().isAlive()) {
//                countBuyers++;
//            }
//        }
//        System.out.println("\tBuyers in the market: " + countBuyers);

        buyerList.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("xxx The market closes xxx");
    }

    private static Map<String, Double> getGoodsList() {
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