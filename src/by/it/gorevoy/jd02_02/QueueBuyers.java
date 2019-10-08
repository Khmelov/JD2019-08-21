package by.it.gorevoy.jd02_02;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    //Sync QueueBuyers.class
    static void add(Buyer buyer){
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        return deque.pollFirst();
    }

}