package by.it.shamuradova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {

    //диспетчер добавляет кассиров нужное количество

    private static volatile int countOfBuyers = 0; //увеличится, когда заходят покупатели, countOfBuyers=countOfServedBuyers
    private static volatile int countOfServedBuyers = 0; //увеличим, когда покупатель обслужился и уходит
    private static List<Cashier> cashiers = new ArrayList<>();
    private static final Object monitor = new Object();
    private static final int MAX = 100;
    private static volatile int countOfBuyersInMarket = 0;

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

    static int getCountOfBuyersInMarket() {
        return countOfBuyersInMarket;
    }

    static boolean marketIsOpened() {
        return !planComplete() || countOfBuyersInMarket > 0;
    }

    static boolean planComplete() {
        synchronized (monitor) {
            return countOfServedBuyers == MAX;  //исправть
        }
    }

    static int buyerInMarket() {
        synchronized (monitor) {
            countOfBuyers++;
            countOfBuyersInMarket++;
            return countOfBuyers;  //or countOfBuyersInMarket- при необходимости сделать для него отдельный метод
        }
    }

    static int buyerLeaveMarket() {
        synchronized (monitor) {
            return countOfBuyersInMarket--;
        }
    }

    static int getMax() {
        return MAX;
    }

    static int getCountOfServedBuyers() {
        return countOfServedBuyers++;
    }
}
