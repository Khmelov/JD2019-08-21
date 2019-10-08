package by.it.daletski.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Map<String, Double> basket;

    Buyer(int number) {

        super ("Bayer № " + number);
    }

    @Override
    public void run() {

        enterToMarket ();
        chooseGoods ();
        goOut ();
        takeBasket ();
        putGoodsToBasket ();

    }

    @Override
    public void enterToMarket() {

        System.out.println (this + " enter to Market");


    }

    @Override
    public void chooseGoods() {

        System.out.println (this + " start choose goods");
        int timeout = Util.random (2000);
        Util.sleep (timeout);
        System.out.println (this + " end choose goods");

    }

    @Override
    public void goOut() {

        System.out.println (this + " leave to Market");
    }


    @Override
    public String toString() {

        return this.getName ();
    }


    @Override
    public void takeBasket() {
        System.out.println (this + " take basket");
        int timeout = Util.random (200);
        Util.sleep (timeout);
    }

    @Override
    public void putGoodsToBasket() {
        int countGoods = Util.random (1, 4);
        if (basket == null)
            System.out.println (this + " no basket");
        else {
            for (int i = 1; i <= countGoods; i++) {
                int timeout = Util.random (100, 200);
                Util.sleep (timeout);
                Map.Entry<String, Double> e = Market.randomGoods ();
                if (e != null) {
                    basket.put (e.getKey (), e.getValue ());
                    System.out.println (this + " put " + e.getKey () + " - " + e.getValue () + " cash");
                }
            }
        }
    }
}
