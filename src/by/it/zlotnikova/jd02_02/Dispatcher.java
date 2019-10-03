package by.it.zlotnikova.jd02_02;

public class Dispatcher {

    public static int kSpeed = 1000;

    private static final int MAX_BUYERS = 10;
    private static volatile int buyerCounter = 0;
    private static volatile int buyerInMarket = 0;
    private static final Object monitor = new Object();

    static boolean marketIsOpen() {
        synchronized (monitor) {
            return !planComplete() || buyerInMarket > 0;
        }
    }

    static boolean planComplete() {
        synchronized (monitor) {
            return buyerCounter == MAX_BUYERS;
        }
    }

    static int buyerEnters() {
        synchronized (monitor) {
            buyerCounter++;
            buyerInMarket++;
        }
        return buyerCounter;
    }

    static void buyerLeaves() {
        synchronized (monitor) {
            buyerInMarket--;
        }
    }
}
