package by.it.shamuradova.jd02_02;


import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    Basket basket;
    List<Good> goods;
    boolean retiree;
    double check=0;  //чек, который выводим в консоль после обслуживания покупателя

    public Buyer(boolean retiree, List<Good> goods) {
        this.retiree = retiree;
        this.setName("Покупатель № " + Dispatcher.buyerInMarket());
        this.goods = goods;
        basket = new Basket();
        start();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин >>>>>>>>");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " выбирает товары");
        try {
            int pause = Rnd.fromTo(500, 2000);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(this + " выбрал");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.buyerLeaveMarket();
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
        wentToTheQueue();
        goOut();
    }
    //покупатель в очереди и ждет, пока его обслужат
    @Override
    public void wentToTheQueue(){

        System.out.println(this + " встал в очередь");
        QueueBuyers.addBuyerInQueue(this); //добавлеям себя в очередь
        synchronized (this){
            try {
                this.wait();   //ждет, пока кассир его обслужит и notify
            } catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
        System.out.println(this + " рассчитался");
        Dispatcher.getCountOfServedBuyers();


    }

    @Override
    public String toString() {
        return this.getName();
    }


    @Override
    public void takeBasket() {
        System.out.println(this + " взял корзину"); //можно создать очередь для корзинок, берет-отнимаем с очереди, возвращает - прибавляем
    }                                                 //такая очередь пусть будет в shop

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

        basket.listOfProducts.stream().forEach(good -> System.out.println("Покупатель № " + this+ " товар: " + good.name + " " + good.price));
    }
}
