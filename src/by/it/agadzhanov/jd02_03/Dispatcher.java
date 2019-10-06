package by.it.agadzhanov.jd02_03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int timeFactor = 1000;              //не менять, чтобы не было ошибки приведения к int в методах sleep
    static final double pensionerFactor = 1.5;       //поле, замедляющее все действия пенсионеров

    //Параметры покупателя
    private static final int MAX_BUYERS = 100;
    private static final AtomicInteger buyerCount = new AtomicInteger(0);
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersInQueue = new AtomicInteger(0);
    static Semaphore choosingGoodsSemaphore = new Semaphore(20);

    //Параметры кассира
    static final int MAX_CASHIERS = 5;
    private static final AtomicInteger cashierCount = new AtomicInteger(0);
    static ConcurrentHashMap<Cashier, Integer> cashierRevenueMap = new ConcurrentHashMap<>();
    static final AtomicInteger totalRevenue = new AtomicInteger(0);

    static boolean marketIsOpen() {
        return !planComplete() || buyersInMarket.get() > 0;
    }

    static boolean planComplete() {
        return buyerCount.get() == MAX_BUYERS;
    }

    static int buyerEnterMarket() {
        buyerCount.getAndIncrement();
        buyersInMarket.getAndIncrement();
        return buyerCount.get();
    }

    static void buyerExitMarket() {
        buyersInMarket.getAndDecrement();
    }

    static void buyerEnterQueue() {
        buyersInQueue.getAndIncrement();
    }

    static void buyerExitQueue() {
        buyersInQueue.getAndDecrement();
    }

    static int cashierStartWorking() {
        cashierCount.getAndIncrement();
        return cashierCount.get();
    }

    static synchronized void printData() {
        StringBuilder cashBoxData = new StringBuilder();
        for (Map.Entry<Cashier, Integer> cashierRevenueEntry : cashierRevenueMap.entrySet()) {
            cashBoxData.append(String.format("%13s", cashierRevenueEntry.getKey()));
        }
        cashBoxData.append(String.format("%21s%17s", "Человек в очереди", "Общая выручка"));
        cashBoxData.append("\n");
        for (Map.Entry<Cashier, Integer> cashierRevenueEntry : cashierRevenueMap.entrySet()) {
            cashBoxData.append(String.format("%14d", cashierRevenueEntry.getValue()));
        }
        cashBoxData.append(String.format("%20d%16d", buyersInQueue.get(), totalRevenue.get()));
        cashBoxData.append("\n");
        System.out.print(cashBoxData);
    }

    static void resetBuyerCount() {
        buyerCount.set(0);
    }

    static void resetCashierCount() {
        cashierCount.set(0);
    }

    static void resetTotalRevenue() {
        totalRevenue.set(0);
    }

    static void resetCashierRevenueMap() {
        cashierRevenueMap.clear();
    }
}
