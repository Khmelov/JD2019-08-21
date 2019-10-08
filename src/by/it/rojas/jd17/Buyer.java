package by.it.rojas.jd17;

import java.util.HashMap;
import java.util.Map;
import static by.it.rojas.jd17.Runner.Good;

public class Buyer extends Thread implements Runnable, IBuyer,IUseBasket {
    Buyer(){
        this.setName("Buyer № "+ Dispatcher.buyerInMarket()+" ");
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
        System.out.println(this + "entered the market <--");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void chooseGoods() {
        int pause = Rnd.fromTo(500,2000);
        Util.sleep(pause);
        System.out.println("\t"+this+"took the product ");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "left the market -->");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void goToQueue() {
        System.out.println(this+"came in line");
        QueueBuyers.add(this);
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+"left the line");
    }

    @Override
    public void takeBasket() {
        int pause = Rnd.fromTo(100,200);
        Util.sleep(pause);
        System.out.println(this + "took the basket");
    }

    @Override
    public void putGoodsToBasket() {
        HashMap<String,String> Basket = new HashMap<>();
        int BuyerChoice = (int)(Math.random()*4+1);
        for (Map.Entry<String, String> entry : Good.entrySet()) {
            if (Basket.size()< BuyerChoice) {
                Basket.put(entry.getKey(),entry.getValue());
                System.out.println(this +"put "+entry.getKey() + "cost" + entry.getValue()+" to the basket");
            }
            int pause = Rnd.fromTo(100,200);
            Util.sleep(pause);
        }
    }
}
