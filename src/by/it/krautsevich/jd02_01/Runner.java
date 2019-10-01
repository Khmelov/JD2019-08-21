package by.it.krautsevich.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static private int countBuyers = 0;
    static private int time = 0 ;

    public static void main(String[] args) throws InterruptedException {

        Queue <Buyer> queue = new ArrayDeque<>(300) ;
        System.out.println("Магазин открылся");
       while (time < 120) {
           int count = Rnd.fromTo(0 , 2) ;
           for (int i = 0; i < count ; i++) {
               Buyer buyer = new Buyer(countBuyers) ;
               countBuyers++ ;
               queue.add(buyer) ;
           }
           Thread.sleep(1000);
           time++ ;
       }
       for (Buyer element : queue) {element.join();}
        System.out.println("Магазин закрылся. SORRY, WE ARE CLOSED!!! ");
    }
}
