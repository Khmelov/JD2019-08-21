package by.it.rubatskii.jd02_03;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private  boolean pensioner;
    private boolean waiting = false;

    void resetWaiting() {
        waiting = false;
    }

    Basket getBasket() {
        return basket;
    }

    boolean isPensioner() {
        return pensioner;
    }

    Buyer() {
        int randomNumber = Util.randomFromTo(1, 4);
        pensioner = randomNumber == 1;
        if (pensioner) {
            this.setName("Buyer retiree №" + Dispatcher.buyerEnterMarket());
        } else {
            this.setName("Buyer №" + Dispatcher.buyerEnterMarket());
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        returnBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {

        System.out.println(">>> " + this + " go to Market");
    }

    @Override
    public void takeBasket() {

        int pause = Util.randomFromTo(100, 200);
        if (pensioner) {
            Util.sleepPensioner(pause);
        } else {
            Util.sleepAccelerated(pause);
        }
        try {
            basket = BasketStack.takeBasket();
        } catch (InterruptedException e) {
            System.out.println(this.getName() + ": exception to takeBasket()!");
        }
        System.out.println(this + " take a basket");
    }

    @Override
    public void chooseGoods() {
        try {
            Dispatcher.choosingGoodsSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println(this + "exception");
        }
        int pause = Util.randomFromTo(500, 2000);
        if (pensioner) {
            Util.sleepPensioner(pause);
        } else {
            Util.sleepAccelerated(pause);
        }
        basket.fillBasket();
        System.out.println(this + "chose the goods");
        Dispatcher.choosingGoodsSemaphore.release();
    }

    @Override
    public void putGoodsToBasket() {

            int pause = Util.randomFromTo(100, 200);
            if (pensioner) {
                Util.sleepPensioner(pause);
            } else {
                Util.sleepAccelerated(pause);
            }
        }

    @Override
    public void goToQueue() {
        BuyersQueue.put(this);
        waiting = true;
        System.out.println(this + "  go to queue");
        synchronized (this) {
            while (waiting) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println("exception buyer " + this);
                }
            }
        }
        System.out.println(this + " leave to queue");
    }

    @Override
    public void returnBasket() {
        BasketStack.putBasketBack();
    }

    @Override
    public void goOut() {
        Dispatcher.buyerExitMarket();
        System.out.println(this + " leave to Market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
