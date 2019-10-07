package by.it.rojas.jd18;

import java.util.*;
import java.util.concurrent.Semaphore;


public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {

    private int sum ;
    private List<String> mySet ;
    private boolean iWait = false ;

    private static Semaphore semaphore = new Semaphore(20) ;

    public void setIWait(boolean iWait) {
        this.iWait = iWait;
    }

    public int getSum() {
        return sum;
    }

    public List<String> getMySet() {
        return mySet;
    }

    Buyer () {
        super("Покупатель № " + Dispatcher.buyerInMarket() + " ");
        this.sum = 0 ;
        this.mySet = new ArrayList<>() ;
        start();
    }

    @Override
    public  void run() {
        try {
            semaphore.acquire();
            enterToMarket();
            takeBasket();
            putGoodsToBasket();
            chooseGoods();
            goToQueue();
            goToOut();
        }
        catch (InterruptedException e) {
            System.out.println(this +" не может попасть вмагазин.");
        }
        finally {
            semaphore.release();
        }

    }

    @Override
    public String toString() {return this.getName() ;}

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин (==>)");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина (<==)");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void goToQueue() {
        System.out.println(this + "встал в очередь.");
        QueueBuyers.add(this);
        iWait= true ;
        synchronized (this)
        {try {
            while (iWait)
                this.wait();
        } catch (InterruptedException e)
        {
            System.out.println(this + " уснул в очереди. ");
        }}
        System.out.println(this + " расплатился (покинул очередь).");
    }

    @Override
    public void chooseGoods() {
        try{
            int pause = Rnd.fromTo(500 , 2000) ;
            Thread.sleep(pause);
        }
        catch (InterruptedException e) {
            System.out.println(this + "задерживается в магазине");
        }
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void takeBasket() {
        try {
            int pause = Rnd.fromTo(100 , 200);
            Thread.sleep(pause);
            System.out.println(this + "взял корзинку");
        }
        catch (InterruptedException e) {
            System.out.println(this + "не может найти корзинку");}
    }

    @Override
    public void  putGoodsToBasket() {try {
        int pause = Rnd.fromTo(100 , 200);
        Thread.sleep(pause);
        int numberOfGoods = Rnd.fromTo(1, 4);

        Set<Integer> numberOfNeededList = new HashSet<>() ;
        while (numberOfNeededList.size()!= numberOfGoods )
        {numberOfNeededList.add(Rnd.fromTo(0,14));}
        for (Integer element : numberOfNeededList)
        {Set<Map.Entry<String, Integer>> entry_set = Runner.listOfGoods.entrySet();
            Iterator<Map.Entry<String, Integer>> it = entry_set.iterator() ;

            for(int k = 0 ; k < element & (it.hasNext())  ; k++ )
            {it.next() ; }
            Map.Entry<String, Integer> me = it.next() ;

            sum = sum + me.getValue() ;
            mySet.add(me.getKey()) ;
        }

        StringBuilder myString = new StringBuilder();
        myString.append(this).append("положил в корзинку: ");
        String delimeter = "";
        for ( String good : mySet) {
            myString.append(delimeter) ;
            myString.append(good);
            delimeter = ", " ;
        }
        myString.append("; сумма покупки = ").append(sum).append("рублей.");

        System.out.println(myString);
    }
    catch (InterruptedException e) {
        System.out.println(this + "не может выбрать товар");
    }
    }
}
