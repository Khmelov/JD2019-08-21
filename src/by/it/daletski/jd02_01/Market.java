package by.it.daletski.jd02_01;

import java.util.*;

public class Market {

    public static void main(String[] args) {
        int numberBuyer = 0;
        System.out.println ("Market opened");
        List<Buyer> buyerList = new ArrayList<> (200);
        for (int time = 0; time <= 120; time++) {
            int max = Util.random (2);
            for (int i = 0; i < max; i++) {
                Buyer b = new Buyer (++numberBuyer);
                buyerList.add (b);
                b.start ();
            }
            Util.sleep (1000);
        }
        for (Buyer b : buyerList) {
            try {
                b.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }

        System.out.println ("Market closed");
    }

    private static Map<String, Double> productList = new HashMap<> (20);

    static Map.Entry<String, Double> randomGoods() {
        productList.putIfAbsent ("Bread", 2.5);
        productList.putIfAbsent ("Juice", 1.0);
        productList.putIfAbsent ("Milk", 1.5);
        productList.putIfAbsent ("Fruit", 5.2);

        Set<Map.Entry<String, Double>> entries = productList.entrySet ();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator ();
        int number = Util.random (1, productList.size ());
        int i = 0;
        while (iterator.hasNext ()) {
            i++;
            if (i == number)
                return iterator.next ();
            else iterator.next ();
        }
        return null;
    }

}
