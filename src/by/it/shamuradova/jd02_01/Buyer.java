package by.it.shamuradova.jd02_01;

import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    int num;
    Basket basket;
    List<Good> goods;
    boolean retiree;

    public Buyer(int num, boolean retiree, List<Good> goods) {
        this.num = num;
        this.retiree = retiree;
        this.setName("Покупатель № " + num);
        this.goods = goods;
        basket = new Basket();
        start();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            int pause = Rnd.fromTo(500, 2000);
            Thread.sleep(pause);

        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        try {
            int pause = Rnd.fromTo(100, 200);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        takeBasket();
        try {
            int pause = Rnd.fromTo(100, 200);
            if (retiree) {
                pause *= 1.5;
            }
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        putGoodsToBacket();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }


    @Override
    public void takeBasket() {
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        int countProduct = Rnd.fromTo(1, 4);
        System.out.println(this + " кладет товар в корзину");
        for (int i = 0; i < countProduct; i++) {
            int productIndex = Rnd.fromTo(1, goods.size() - 1);
            Good good = goods.get(productIndex);
            basket.addGoods(good);
        }
        System.out.println(this + " положил товар(ы) в корзину");

        basket.listOfProducts.stream().forEach(good -> System.out.println("Покупатель №" + num + " товар: " + good.name + " " + good.price));
    }
}
