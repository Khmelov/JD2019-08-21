package by.it.akhmelev.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyers {

    private static Deque<Buyer> deque=new LinkedList<>();

    //sync QueueBuyers.class
    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    //sync QueueBuyers.class
    static  synchronized Buyer extract(){
        return deque.pollFirst();
    }



}
