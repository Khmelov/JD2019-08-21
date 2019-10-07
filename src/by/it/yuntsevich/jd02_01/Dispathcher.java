package by.it.yuntsevich.jd02_01;

class Dispathcher {
    static int kSpeed = 1000;

    private static volatile int buyerInMarket = 0;

    static synchronized void buyerInMarket() {
        buyerInMarket++;

    }

    static synchronized void buyerLeftMarket() {
        buyerInMarket--;

    }

    static int getBuyerInMarket() {
        return buyerInMarket;
    }
}
