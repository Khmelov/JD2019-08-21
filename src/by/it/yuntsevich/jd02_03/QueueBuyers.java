package by.it.yuntsevich.jd02_03;

import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

class QueueBuyers {
    private static Semaphore semaphore = new Semaphore(30);

    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Buyer> queuePens = new LinkedBlockingDeque<>(30);

    //sync QueueBuyers.class
    static void addBuyer(Buyer buyer) {
        try {
            semaphore.acquire();
            if (buyer.isPensioneer()) {
                queuePens.putLast(buyer);
            } else {
                deque.putLast(buyer);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static Buyer extract() {
        try {
            if (!(queuePens.isEmpty())) {
                return queuePens.pollFirst();
            } else {
                return deque.pollFirst();
            }
        } finally {
            semaphore.release();
        }
    }

    static Deque<Buyer> getDeque() {
        return deque;
    }

    synchronized static int length() {
        return queuePens.size() + deque.size();
    }
}
