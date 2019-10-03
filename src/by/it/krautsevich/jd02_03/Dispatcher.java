package by.it.krautsevich.jd02_03;

public class Dispatcher {

    private static final int MAX_BUYERS =  100;
    private static volatile int buyerCounter = 0 ;
    private static volatile int buyersInMarket = 0 ;
    private static final Object monitor = new Object() ;

    static boolean marketIsOpened () {
        synchronized (monitor) {
        return ((!planComplete()) || (buyersInMarket!=0));}
    }

    static int buyerInMarket () {
        synchronized (monitor) {
        buyerCounter++ ;
        buyersInMarket++ ;
        return buyerCounter ;}
    }

    static void buyerLeaveMarket () {
        synchronized (monitor) {
        buyersInMarket-- ;}
    }

    static boolean planComplete () {
        synchronized (monitor) {
        return buyerCounter == MAX_BUYERS ;}
    }
}
