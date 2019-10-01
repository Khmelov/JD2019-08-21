package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int kSpeed = 1000;

    private static final int MAX_BUYERS = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);


    static void reset(){
        buyerCounter.set(0);
    }

    static boolean marketIsOpened() {
            return !planComplete() || buyerInMarket.get() > 0;
    }

    static boolean planComplete() {
            return buyerCounter.get() == MAX_BUYERS;
    }

    static int buyerInMarket() {
            buyerCounter.getAndIncrement();
            buyerInMarket.getAndIncrement();
            return buyerCounter.get();
    }

    static void buyerLeaveMarket() {
            buyerInMarket.getAndDecrement();
    }

}
