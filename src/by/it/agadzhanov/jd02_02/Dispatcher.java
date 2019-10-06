package by.it.agadzhanov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Dispatcher {

    static final int timeFactor = 50;              //не менять, чтобы не было ошибки привеления к int в методах sleep
    static final double pensionerFactor = 1.5;     //поле, замедляющее все действия пенсионеров

    private static final int MAX_BUYERS = 100;
    private static int buyerCount = 0;
    private static double buyersInMarket = 0;
    //private static double buyersPerCashier = 5;

    //private static final int MAX_CASHIERS = 100;
    //static int cashierCount = 0;
    //static int cashiersNeeded;
    static List<Cashier> cashierList = new ArrayList<>();

    private static final Object monitor = new Object();

    static boolean marketIsOpen() {
        synchronized (monitor) {
            return !planComplete() || buyersInMarket > 0;
        }
    }

    static boolean planComplete() {
        synchronized (monitor) {
            return buyerCount == MAX_BUYERS;
        }
    }

    static int buyerEnter() {
        synchronized (monitor) {
            buyerCount++;
            buyersInMarket++;
        }
        return buyerCount;
    }

    static void buyerExit() {
        synchronized (monitor) {
            buyersInMarket--;
        }
    }

    /*
    static void setCashierNumber() {
        if (BuyersQueue.buyersQueue.size() <= 19) {
            cashiersNeeded = (int) Math.ceil(BuyersQueue.buyersQueue.size() / buyersPerCashier);
        }
        else {
            cashiersNeeded = MAX_CASHIERS;
        }
        while (cashiersNeeded != Dispatcher.cashierCount) {
            if (cashiersNeeded > Dispatcher.cashierCount) {
                Dispatcher.cashierStart();
            }
            else {
                Dispatcher.cashierStop();
            }
        }
    }

    static int cashierStart() {
        Cashier cashier = new Cashier();
        Thread thread = new Thread(cashier);
        thread.start();
        synchronized (monitor) {
            cashierCount++;
            return cashierCount;
        }
    }

    static void cashierStop() {
        synchronized (monitor) {
            cashierCount--;
        }
    }
    */

    static void reset() {
        buyerCount = 0;
    }
}
