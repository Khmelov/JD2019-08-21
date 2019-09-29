package by.it.akhmelev.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {


    public static void main(String[] args) throws InterruptedException {
        int numberBuyer=0;
        System.out.println("Market opened");
        List<Buyer> buyerList=new ArrayList<>(200);
        for (int time = 0; time <= 120; time++) {
            int max=Util.random(2);
            for (int i = 0; i < max; i++) {
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
