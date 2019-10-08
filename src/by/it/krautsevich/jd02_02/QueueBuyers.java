package by.it.krautsevich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void add(Buyer buyer) {deque.addLast(buyer);}

    static synchronized Buyer extract() {return deque.pollFirst() ;}

    static synchronized int getSizeOfDeque(){return deque.size();}

}
