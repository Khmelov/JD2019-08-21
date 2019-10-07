package by.it.akhrem.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispathcher {
    static int kSpeed = 10;

    static final int MAX_BUYERS = 100;
    static final AtomicInteger buyerCounter = new AtomicInteger(0);
    static final AtomicInteger buyerInMarket = new AtomicInteger(0);

    static  boolean marketIsOpened() {
        return buyerCounter.get() < MAX_BUYERS || buyerInMarket.get() > 0;
    }

    static void buyerInMarket() {
        buyerCounter.incrementAndGet();
        buyerInMarket.incrementAndGet();
    }

    static  void  buyerLeaveMarket() {
        buyerInMarket.getAndDecrement();
    }

    static boolean planComplete() {
        return  buyerCounter.get() == MAX_BUYERS;
    }
}
