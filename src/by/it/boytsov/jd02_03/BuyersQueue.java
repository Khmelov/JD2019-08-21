package by.it.boytsov.jd02_03;


import java.util.Deque;
import java.util.LinkedList;

class BuyersQueue {

    private static Deque<Buyer> buyersQueue = new LinkedList<>();

    static synchronized void add(Buyer buyer) {
        buyersQueue.addLast(buyer);
    }

    static void put(Buyer buyer) {
            try {
                buyersQueue.addLast(buyer);
            } finally {
                Dispatcher.buyerEnterQueue();
            }

    }
    static synchronized Buyer callFromQueue() {
        return buyersQueue.pollFirst();

    }

}