package by.it.akhrem.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static Deque<Buyer> deque = new LinkedList<>();
    //Sync QueueBuyers.class
    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    static Buyer extract() {
        return deque.pollFirst();
    }

}
