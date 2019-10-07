package by.it.rojas.jd18;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Runner {

    static public HashMap<String, Integer> listOfGoods = new HashMap<>() ;

    public static void main(String[] args) throws InterruptedException {


        listOfGoods.put("Хлеб" , 5) ;
        listOfGoods.put("Картошка" , 3) ;
        listOfGoods.put("Селедка" , 10) ;
        listOfGoods.put("Мясо" , 15) ;
        listOfGoods.put("Макароны", 4);
        listOfGoods.put("Консервы", 8);
        listOfGoods.put("Курица", 9);
        listOfGoods.put("Батон", 5);
        listOfGoods.put("Водка" , 12) ;
        listOfGoods.put("Пиво" , 5) ;
        listOfGoods.put("Морковь", 3);
        listOfGoods.put("Лук", 2);
        listOfGoods.put("Мука", 6);
        listOfGoods.put("Мороженое", 6);
        listOfGoods.put("Шоколад", 6);

        Queue<Thread> queue = new ArrayDeque<>(300) ;
        System.out.println("Магазин открылся");

        ExecutorService poolForCashiers = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i) ;
            poolForCashiers.execute(cashier);

        }
        while (!Dispatcher.planComplete()) {
            int count = Rnd.fromTo(0 , 2) ;
            for (int i = 0; (i <= count) && (!Dispatcher.planComplete()) ; i++) {
                Buyer buyer = new Buyer() ;
                queue.add(buyer) ;
            }
            Thread.sleep(1000);
        }
        for (Thread element : queue) {element.join();}
        poolForCashiers.shutdown();
        while (!poolForCashiers.isTerminated()) {Thread.yield();}
        System.out.println("Магазин закрылся. SORRY, WE ARE CLOSED!!! ");
    }
}
