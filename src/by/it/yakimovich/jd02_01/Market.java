package by.it.yakimovich.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market is open");
        for (int time = 0; time <= 120; time++) {
            int countBuyer = Util.random(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer b = new Buyer(time);
                b.start();
            }
            Util.sleep(1000);
        }
        System.out.println("market is closed");
    }

    private static Map<String, Double> goodsList = new HashMap<>(20);

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
        int number =Util.random(1, goodsList.size());
        int i = 0;
        while (itr.hasNext()) {
            i++;
            if (i == number)
                return itr.next();
            else itr.next();
        }
        return null;
    }
}
