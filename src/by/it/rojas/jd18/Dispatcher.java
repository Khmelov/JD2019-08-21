package by.it.rojas.jd18;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int kSpeed = 1000;
    private static final int MAX_BUYERS =  100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0) ;
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0) ;


    static boolean marketIsOpened () {
        return ((!planComplete()) || (buyersInMarket.get()!=0));
    }

    static int buyerInMarket () {

        buyerCounter.getAndIncrement() ;
        buyersInMarket.getAndIncrement() ;
        return buyerCounter.get() ;
    }

    static void buyerLeaveMarket () {
        buyersInMarket.getAndDecrement() ;
    }

    static boolean planComplete () {
        return buyerCounter.get() == MAX_BUYERS ;
    }
}
