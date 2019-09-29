package by.it.akhmelev.jd02_02;

class Dispatcher {

    static int kSpeed = 1000;

    private static final int MAX_BUYERS = 100;
    private static volatile int buyerCounter = 0;
    private static volatile int buyerInMarket = 0;
    private static final Object monitor = new Object();


//    static void reset(){
//        buyerCounter=0;
//    }

    static boolean marketIsOpened() {
        synchronized (monitor) {
            return !planComplete() || buyerInMarket > 0;
        }
    }

    static boolean planComplete() {
        synchronized (monitor) {
            return buyerCounter == MAX_BUYERS;
        }
    }

    static int buyerInMarket() {
        synchronized (monitor) {
            buyerCounter++;
            buyerInMarket++;
            return buyerCounter;
        }
    }

    static void buyerLeaveMarket() {
        synchronized (monitor) {
            buyerInMarket--;
        }
    }

}
