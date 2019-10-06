package by.it.zavadski.jd02_02;


import java.util.ArrayList;
import java.util.List;

import static by.it.zavadski.jd02_02.Dispatcher.closeTime;
import static by.it.zavadski.jd02_02.Dispatcher.planComplete;
import static by.it.zavadski.jd02_02.Util.random;
import static by.it.zavadski.jd02_02.Util.sleep;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        int numberBuyer = 0;
        List<Buyer> buyerList = new ArrayList<>(200);
        System.out.println("Market opened");
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
        }
        while (!planComplete()) {
            int maxBuyers = random(2);
            for (int i = 0; i < maxBuyers; i++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer();
                    buyerList.add(buyer);
                    buyer.start();
                }
            }
            sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("JOIN ERROR: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Market closed");
    }
}

