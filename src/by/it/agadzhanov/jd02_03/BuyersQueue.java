package by.it.agadzhanov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BuyersQueue {

    private static BlockingDeque<Buyer> buyersQueue = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Buyer> pensionersQueue = new LinkedBlockingDeque<>(10);

    static void put(Buyer buyer) {
        if (!buyer.isPensioner()) {
            try {
                buyersQueue.putLast(buyer);
            } catch (InterruptedException e) {
                System.out.println("Помещение элемента в очередь было прервано!");
            } finally {
                Dispatcher.buyerEnterQueue();
            }
        } else {
            try {
                pensionersQueue.putLast(buyer);
            } catch (InterruptedException e) {
                System.out.println("Помещение элемента в очередь было прервано!");
            } finally {
                Dispatcher.buyerEnterQueue();
            }
        }
    }

    static Buyer callBuyerFromQueue() {
        return buyersQueue.pollFirst();
    }

    static Buyer callPensionerFromQueue() {
        return pensionersQueue.pollFirst();
    }
}
