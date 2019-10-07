package by.it.yuntsevich.jd02_02;

class Dispathcher {
    static int kSpeed = 10000;

    private static final int MAX_BUYERS = 100;

    private static volatile int buyerCounter = 0;

    private static volatile int buyerInMarket = 0;

    static synchronized boolean marketIsOpened() {
        return !planComplete() || buyerInMarket > 0;
    }

    static synchronized boolean planComplete() {
        return buyerCounter == MAX_BUYERS;
    }

    static synchronized void buyerInMarket() {
        buyerCounter++;
        buyerInMarket++;
    }

    static synchronized void buyerLeftMarket() {
        buyerInMarket--;
    }
}
