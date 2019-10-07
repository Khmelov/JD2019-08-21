package by.it.yuntsevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispathcher {
    static int kSpeed = 10000;

    private static final int MAX_BUYERS = 100;

    private static final AtomicInteger buyerCounter = new AtomicInteger(0);

    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);

    static synchronized boolean marketIsOpened() {
        return !planComplete() || buyerInMarket.get() > 0;
    }

    static synchronized boolean planComplete() {
        return buyerCounter.get() == MAX_BUYERS;
    }

    static synchronized void buyerInMarket() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndIncrement();
    }

    static synchronized void buyerLeftMarket() {
        buyerInMarket.getAndDecrement();
    }
}
