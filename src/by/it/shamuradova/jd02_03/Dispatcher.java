package by.it.shamuradova.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
    private static final AtomicInteger countOfBuyers = new AtomicInteger(0);
    //очередь кассиров, последнего кассира закрывать, пока не останется ни один покупатель.
    //если очередь длинная - добавляем кассира, короткая - убавляем
    private static List<Cashier> cashiers = new ArrayList<>();
    private static final int MAX = 100;
    private static final AtomicInteger countOfBuyersInMarket = new AtomicInteger(0);

    //нужно расчитать необходимое количество кассиров, 5 покупателей= 1 кассир
    public void run() {
        //цикл, который станет false, когда завершится все обслуживание
        while (marketIsOpened()) {
            while (buyerInMarket() > 0) {
                //создаются кассиры
                if (QueueBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {//if(QueueBuyers.getCount()>cashier.size()*5 )
                    Cashier cashier = new Cashier(cashiers.size() + 1);
                    Thread thread = new Thread(new Cashier(cashiers.size() + 1));
                    cashiers.add(cashier);
                    thread.start();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* static void printRevenueTable() {
        int totalRevenue = 0;
        synchronized (cashiers) {
            for (Cashier cashier : cashiers) {
                totalRevenue += cashier.getRevenue();
                System.out.println("Cahier #" + cashier.num + ", revenue: " + cashier.getRevenue());
            }
        }
        System.out.println("Buyers in queue:" + getCountOfBuyersInMarket());
        System.out.println("Total revenue: " + totalRevenue);
    }*/

//    static int getCountOfBuyersInMarket() {
//        return countOfBuyersInMarket;
//    }
    static boolean marketIsOpened() {
        return !planComplete() || countOfBuyersInMarket.get() > 0;
    }
    static boolean planComplete() {
            return countOfBuyers.get() == MAX;
    }

    static int buyerInMarket() {
            countOfBuyers.getAndIncrement();
            countOfBuyersInMarket.getAndIncrement();
            return countOfBuyers.get();
    }
    static int buyerLeaveMarket() {
        return countOfBuyersInMarket.getAndDecrement();
    }
    static int getMax() {
        return MAX;
    }
}
