package by.it.rubatskii.jd02_01;




import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    Map<String, Double> basket = null;

    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        this.getName();
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        chooseGoods();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Util.random(2000);
        Util.sleep(timeout);
        System.out.println(this + " end to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leave to Market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int pause = Util.random(100,200);
        basket = new HashMap<>(4);
        Util.sleep(pause);
        System.out.println(this + " take basket");

    }

    @Override
    public void putGoodsToBasket() {
        int cntGoods = Util.random(1, 4);
        if (basket == null)
            System.out.println(this + " doesn't have a basket");
        else {
            for (int i = 1; i <= cntGoods; i++) {
                int timeout = Util.random(100, 200);
                Util.sleep(timeout);
                Map.Entry<String, Double> e = Market.getRandomGoods();
                if (e != null) {
                    basket.put(e.getKey(), e.getValue());
                    System.out.println(this + " puts " + e.getKey() + " - " + e.getValue() + " $  to basket.");
                }
            }
        }

    }
}


