package by.it.krautsevich.jd02_01;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Market {
    static private int countBuyers = 0;
    static private int time = 0 ;
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

        Queue <Buyer> queue = new ArrayDeque<>(300) ;
        System.out.println("Магазин открылся");
       while (time < 120) {
           int count = Rnd.fromTo(0 , 2) ;
           for (int i = 0; i < count ; i++) {
               Buyer buyer = new Buyer(countBuyers) ;
               countBuyers++ ;
               queue.add(buyer) ;
           }
           Thread.sleep(1000);
           time++ ;
       }
       for (Buyer element : queue) {element.join();}
        System.out.println("Магазин закрылся. SORRY, WE ARE CLOSED!!! ");
    }
}
