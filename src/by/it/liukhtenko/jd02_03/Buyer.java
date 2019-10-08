package by.it.liukhtenko.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import static by.it.liukhtenko.jd02_03.Runner.Good;


public class Buyer extends Thread implements Runnable, IBuyer,IUseBasket {

    private static Semaphore semaphore = new Semaphore(20);

    private double sumReceipt;

    public double getSumReceipt() {
        return sumReceipt;
    }

    private boolean Waiting = false;

    public void setWaiting(boolean waiting) {
        Waiting = waiting;
    }

    Buyer(){
        this.setName("Покупатель № "+ Dispatcher.buyerInMarket()+" ");
        start();
    }
    @Override
    public void run(){
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошёл в магазин <--");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
            int pause = Rnd.fromTo(500,2000);
            Util.sleep(pause);
            System.out.println("\t"+this+"выбрал товар ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина -->");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void goToQueue() {
        System.out.println(this+"добавился в очередь");
        QueueBuyers.add(this);
        Waiting = true;
        synchronized (this){
            while (Waiting)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+"покинул кассу");
    }

    @Override
    public void takeBasket() {
        int pause = Rnd.fromTo(100,200);
        Util.sleep(pause);
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        HashMap<String,Double> Basket = new HashMap<>();
        int BuyerChoice = (int)(Math.random()*4+1);
        for (Map.Entry<String, Double> entry : Good.entrySet()) {
            if (Basket.size()< BuyerChoice) {
                Basket.put(entry.getKey(),entry.getValue());
                sumReceipt += entry.getValue();
                System.out.println(this +"положил "+entry.getKey() + "стоимостью " + entry.getValue()+" рубля в корзину");
            }
            int pause = Rnd.fromTo(100,200);
            Util.sleep(pause);
        }
    }
}
