package by.it.zhukovskaya.jd02_01;

import java.util.*;

public class Market {
    static Map<String, Double> goodsList = new HashMap<>(20);

    public static Map.Entry<String, Double> getRandomGoods() {
        goodsList.putIfAbsent("milk", 1.5);
        goodsList.putIfAbsent("bread", 1.2);
        goodsList.putIfAbsent("salmon", 1.7);
        goodsList.putIfAbsent("juice", 1.8);
        goodsList.putIfAbsent("lemon", 1.21);
        goodsList.putIfAbsent("potato", 0.35);
        goodsList.putIfAbsent("cucumber", 0.45);
        Set<Map.Entry<String, Double>> entries = goodsList.entrySet();
        Iterator<Map.Entry<String, Double>> itr = entries.iterator();
        int number = Util.random(1, goodsList.size());
        int i = 0;
        while (itr.hasNext()) {
            i++;
            if (i==number)
                return  itr.next();
            else itr.next();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Market opened");
        int numberBuyer = 0;
        List<Buyer> buyerList = new ArrayList<>(200);
        for (int time = 0; time < 120; time++) {
            int countBuyer = Util.random(2);
            for (int i=0; i < countBuyer; i++) {
                Buyer b = new Buyer(++numberBuyer);
                buyerList.add(b);
                b.start();
            }
            Util.sleep(1000);
        }
        for (Buyer b: buyerList)
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Market closed");
    }
}

