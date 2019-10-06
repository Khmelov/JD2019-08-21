package by.it.liukhtenko.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;


public class Runner {

    static HashMap <String,String> Good = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Good.put("молоко "," 2 рубля");
        Good.put("бананы "," 3 рубля");
        Good.put("филе куриное "," 5 рублей");
        Good.put("сок "," 2.5 рубля");

        ArrayList<Thread> actorList = new ArrayList<>(200);
        System.out.println("Магазин открыт");

        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            actorList.add(thread);
            thread.start();
        }
        while (!Dispatcher.planComplete()){
            Util.sleep(1000);
            int count = Rnd.fromTo(0,2);
            for (int i = 0; i <= count; i++) {
                if (!Dispatcher.planComplete())
                {
                    Buyer buyer = new Buyer();
                    actorList.add(buyer);
                }
            }
        }
        for (Thread actor : actorList) {
            actor.join();
        }
        System.out.println("Магазин закрыт");
    }
}
