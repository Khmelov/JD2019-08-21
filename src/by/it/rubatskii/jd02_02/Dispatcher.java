package by.it.rubatskii.jd02_02;

public class Dispatcher {
    static int KSpeed = 1000;
    private static final int MAX_BUYERS = 100;
    private static int buyerCounter = 0;
    private static int buyerInMarket = 0;

    static synchronized boolean marketIsOpened() {
        return !planComplete() || buyerInMarket > 0;
    }

    static synchronized boolean planComplete(){
        return  buyerCounter==MAX_BUYERS;
    }

    static synchronized int buyerInMarket() {
        buyerCounter++;
        buyerInMarket++;
        return buyerCounter;
    }

    static synchronized void buyerLeaveMarket() {
        buyerInMarket--;
    }
}
