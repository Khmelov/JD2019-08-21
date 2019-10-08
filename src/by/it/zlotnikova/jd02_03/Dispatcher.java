package by.it.zlotnikova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static int kSpeed = 1000;

    private static final int MAX_BUYERS = 40;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);

    static boolean marketIsOpen() {
        return !planComplete() || buyerInMarket.get() > 0;
    }

    static boolean planComplete() {
        return buyerCounter.get() == MAX_BUYERS;
    }

    static int buyerEnters() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndIncrement();
        return buyerCounter.get();
    }

    static void buyerLeaves() {
        buyerInMarket.getAndDecrement();
    }
}
