package by.it.zlotnikova.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class BuyersQueue {

    private static Deque<Buyer> deque = new LinkedList<>();

    static synchronized void add(Buyer buyer) {
        deque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return deque.pollFirst();
    }
}
