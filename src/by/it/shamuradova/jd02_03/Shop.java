package by.it.shamuradova.jd02_03;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class Shop {

    static double balance;
    List<Good> listOfGoods=new ArrayList<>();
    private static final BlockingDeque<Basket> basketsQueue = new LinkedBlockingDeque<>(50);

    Shop(){
        System.out.println("Магазин открыт!!!");
    }

    void addToList (Good g){
        listOfGoods.add(g);
    }

    static void returnBasket(Basket basket){
        try {
            basketsQueue.put(basket);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static Basket takeBasket(){
        Basket basket = basketsQueue.poll();
        return basket;
    }


//    boolean shopIsOpened(){
//        return !planComplete() || getCountOfBuyersInMarket() > 0;
//    }












}
