package by.it.zlotnikova.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Buyer extends Thread implements iBuyer, IUseBasket {

    Buyer() {
        //important!!!!
        super("Buyer № " + Dispatcher.buyerEnters());
    }

    private String buyerName = this.getName();

    String getBuyerName() {
        return buyerName;
    }

    private boolean isPensioner;
    private Double speed = 1.0;
    private Map<String, Double> basket = new HashMap<>();

    Buyer(String name) {
        int i = Utils.random(1, 4);
        if (i == 1) {
            this.isPensioner = true;
            this.buyerName = name + " !P";
            this.speed = 1.5;
        } else {
            this.buyerName = name;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.buyerName + ": enters the market");
    }

    @Override
    public void chooseGoods() {
        try {
            Thread.sleep((long) (Utils.random(500, 2000) * speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.buyerName + ": chooses goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this.buyerName + " goes to the queue");
        BuyersQueue.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.buyerName + " leaves the cash-desk");
    }

    @Override
    public void goOut() {
        System.out.println(this.buyerName + ": leaves the market");
        Dispatcher.buyerLeaves();
    }

    @Override
    public void takeBasket() {
        try {
            Thread.sleep((long) (Utils.random(100, 200) * speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.buyerName + ": takes a basket");
    }

    @Override
    public void putGoodsToBasket() {
        // chose from 1 to 4 random goods and add them to HashMap "purchases" ("basket")
        Map<String, Double> purchases = new HashMap<>();

        int limit = Utils.random(1, 4);
        for (int i = 0; i < limit; i++) {
            int randomPurchase = Utils.random(1, Market.goods.entrySet().size());
            int counter = 1;
            Iterator<Map.Entry<String, Double>> it1 = Market.goods.entrySet().iterator();
            while (counter < randomPurchase) {
                it1.next();
                counter++;
            }
            Map.Entry<String, Double> entry = it1.next();
            purchases.put(entry.getKey(), entry.getValue());
        }
        try {
            Thread.sleep((long) (Utils.random(100, 200) * speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //print a list of chosen goods to console
        StringBuilder listOfGoods = new StringBuilder();
        String delimiter = "";
        for (Map.Entry<String, Double> entry : purchases.entrySet()) {
            listOfGoods.append(delimiter)
                    .append(entry.getKey()).append(" (price ")
                    .append(entry.getValue()).append(")");
            delimiter = ", ";
        }
        System.out.println(this.buyerName + ": puts goods into the basket: " + listOfGoods.toString());
    }
}
