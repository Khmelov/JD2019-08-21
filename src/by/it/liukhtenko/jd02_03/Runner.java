package by.it.liukhtenko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Runner {

   public static HashMap <String,Double> Good = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Good.put("молоко ",2.0);
        Good.put("бананы ",3.0);
        Good.put("филе куриное ",4.0);
        Good.put("сок ",2.5);

        System.out.println("Магазин открыт");

        ExecutorService threadpool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
          threadpool.execute(cashier);
        }
        ArrayList<Thread> actorList = new ArrayList<>(200);

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
        threadpool.shutdown();
        while (!threadpool.isTerminated()){
          Thread.yield();
        }
        System.out.println("Магазин закрыт");
    }
}
