package by.it.zavadski.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static by.it.zavadski.jd02_01.Dispatcher.closeTime;
import static by.it.zavadski.jd02_01.Util.random;
import static by.it.zavadski.jd02_01.Util.sleep;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        int numberBuyer=0;
        System.out.println("Market opened");
        List<Buyer> buyerList=new ArrayList<>(200);
        for (int time = 0; time < closeTime; time++) {
            int maxBuyers=random(2);
            for (int i = 0; i <maxBuyers ; i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            buyer.join();
        }
        System.out.println("Market closed");
    }
}
