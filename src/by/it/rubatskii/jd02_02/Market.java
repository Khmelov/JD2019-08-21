package by.it.rubatskii.jd02_02;

import java.util.*;

public class Market {

    static Map<String, Double> goodsList = new HashMap<>(15);

    static Map.Entry<String, Double> getRandomGoods () {
        goodsList.putIfAbsent("Milk", 1.66);
        goodsList.putIfAbsent("Cheese", 9.22);
        goodsList.putIfAbsent("Bread", 1.47);
        goodsList.putIfAbsent("Meat", 9.82);
        goodsList.putIfAbsent("Juice", 6.11);
        goodsList.putIfAbsent("Pasta", 5.25);
        goodsList.putIfAbsent("Sushi", 22.05);
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

    public static void main(String[] args) throws InterruptedException {
        int numberBuyer=0;
        System.out.println("Market opened");
        List<Buyer> buyerList=new ArrayList<>(200);
        for (int time = 1; time <= 120; time++) {
            int countBuyer = Util.random(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            buyer.join();

        }

        System.out.println("Market closed");
    }


}
