package by.it.akhrem.jd02_02;

public class Dispathcher {
    static int kSpeed = 10;

    static final int MAX_BUYERS = 100;
    static int buyerCounter = 0;
    static int buyerInMarket = 0;

    static synchronized boolean marketIsOpened() {
        return buyerCounter < MAX_BUYERS || buyerInMarket > 0;
    }

    static synchronized void buyerInMarket() {
        buyerCounter++;
        buyerInMarket++;
    }

    static synchronized void  buyerLeaveMarket() {
        buyerInMarket--;
    }

    static synchronized boolean planComplete() {
        return  buyerCounter == MAX_BUYERS;
    }
}
