package by.it.liukhtenko.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>();

    static void add(Buyer buyer) {
    deque.addLast(buyer);
    }

    static Buyer extract() {
    return deque.pollFirst();
    }


}
