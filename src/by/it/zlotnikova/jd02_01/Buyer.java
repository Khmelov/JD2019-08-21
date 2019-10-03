package by.it.zlotnikova.jd02_01;

import java.util.*;

public class Buyer extends Thread implements iBuyer, IUseBasket {

    private String name;
    private boolean isPensioner = false;
    private Double speed = 1.0;
    private Map<String, Double> basket = new HashMap<>();

    Buyer(String name) {
        int i = Utils.random(1, 4);
        if (i == 1) {
            this.isPensioner = true;
            this.name = name + " !P";
            this.speed = 1.5;
        } else {
            this.name = name;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.name + ": enters the market");
    }

    @Override
    public void chooseGoods() {
        try {
            Thread.sleep((long) (Utils.random(500, 2000) * speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + ": chooses goods");
    }

    @Override
    public void goOut() {
        System.out.println(this.name + ": leaves the market");
    }

    @Override
    public void takeBasket() {
        try {
            Thread.sleep((long) (Utils.random(100, 200) * speed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + ": takes a basket");
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
        System.out.println(this.name + ": puts goods into the basket: " + listOfGoods.toString());
    }
}
