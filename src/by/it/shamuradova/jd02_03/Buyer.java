package by.it.shamuradova.jd02_03;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waiting = false;
    private static Semaphore semaphor = new Semaphore(20);
    Basket basket;

    void resetWaiting() {
        this.waiting = false;
    }

    List<Good> goods;
    boolean retiree;
    double check = 0;  //чек, который выводим в консоль после обслуживания покупателя

    public Buyer(boolean retiree, List<Good> goods) {
        this.retiree = retiree;
        this.setName("Покупатель № " + Dispatcher.buyerInMarket());
        this.goods = goods;
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBacket();
        wentToTheQueue();
        goOut();
    }
    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин >>>>>>>>");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphor.acquire();
            System.out.println(this + " выбирает товары");
            try {
                int pause = Rnd.fromTo(500, 2000);
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println(this + " выбрал");
        } catch (InterruptedException e) {
            semaphor.release();
        }
    }
    //покупатель в очереди и ждет, пока его обслужат
    @Override
    public void wentToTheQueue() {
        System.out.println(this + " встал в очередь");
        QueueBuyers.addBuyerInQueue(this); //добавлеям себя в очередь
        waiting = true;
        synchronized (this) {
            while (waiting) {
                try {
                    this.wait();   //ждет, пока кассир его обслужит и notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + " рассчитался");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        this.basket = Shop.takeBasket();
        System.out.println(this + " взял корзину");
        try {
            int pause = Rnd.fromTo(100, 200);
            if (retiree) {
                pause *= 1.5;
            }
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    @Override
    public void putGoodsToBacket() {
        try {
            int pause = Rnd.fromTo(100, 200);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        int countProduct = Rnd.fromTo(1, 4);
        System.out.println(this + " кладет товар в корзину");
        for (int i = 0; i < countProduct; i++) {
            int productIndex = Rnd.fromTo(1, goods.size() - 1);
            Good good = goods.get(productIndex);
            this.basket.addGoods(good);
        }
        System.out.println(this + " положил товар(ы) в корзину");

        basket.listOfProducts.stream().forEach(good -> System.out.println("Покупатель № " + this+ " товар: " + good.name + " " + good.price));
    }
    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.buyerLeaveMarket();
        Shop.returnBasket(basket);
    }
}
