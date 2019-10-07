package by.it.daletski.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) throws InterruptedException {

        System.out.println ("Market opened");

        for (int i = 0; i <=2 ; i++) {
            Cashier cashier = new Cashier (i);
            Thread thread = new Thread (cashier);
            thread.start ();
        }


        List<Thread> actorList = new ArrayList<>(200);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            actorList.add(thread);
            thread.start();
        }

        while (!Dispatcher.planComplete()) {
            int max = Util.random(2);
            for (int i = 0; i < max; i++)
                if (!Dispatcher.planComplete ()) {
                    Buyer buyer = new Buyer ();
                    actorList.add (buyer);
                    buyer.start ();
                }
            Util.sleep(1000);
        }
        for (Thread actor : actorList) {
            actor.join();
        }
        System.out.println("Market closed");
    }

}
