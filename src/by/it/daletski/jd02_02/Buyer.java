package by.it.daletski.jd02_02;

import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBasket {


    Buyer(int number) {

        super ("Bayer № " + number);
        Dispatcher.buyerInMarket (); //important!!!

    }

    @Override
    public void run() {
        enterToMarket ();
        chooseGoods ();
        QueueBuyers.add (this);
        goOut ();
        takeBasket ();
        putGoodsToBasket ();

    }

    @Override
    public void enterToMarket() {

        System.out.println (this + " enter to Market >>>");


    }

    @Override
    public void chooseGoods() {

        System.out.printf ("\t%s start choose goods\n", this);
        int timeout = Util.random (2000);
        Util.sleep (timeout);
        System.out.printf ("\t%s end choose goods\n", this);

    }

    @Override
    public void goToQueue() {
        System.out.println (this + " added to Queue");
        QueueBuyers.add (this);
        synchronized (this) {
            try {
                this.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println (this + " leave Cashier");
    }


    @Override
    public void goOut() {
        System.out.println (this + " leave to Market <<<");

    }


    @Override
    public String toString() {

        return this.getName ();
    }


    @Override
    public void takeBasket() {
        System.out.println (this + " take basket");
        int timeout = Util.random (100, 200);
        Util.sleep (timeout);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println (this + " put goods to basket");
        int timeout = Util.random (100, 200);
        ArrayList<String> goodsNames = new ArrayList<> ();
        System.out.printf ("%-10s put in basket:\n", this);
        for (int i = 0; i < timeout; i++) {
            String inBasket = goodsNames.get (timeout - 1);

        }
    }
}

