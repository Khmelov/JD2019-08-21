package by.it.yuntsevich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBucket {
    private Map<String, Double> bucket = null;
    private boolean pensioneer = false;
    boolean isPensioneer() {
        return pensioneer;
    }

    Buyer(int num) {

        super("Покупатель № " + num + " ");
        Dispathcher.buyerInMarket();
    }

    @Override
    public void run() {

        enterToMarket();
        takeBucket();
        chooseGoods();
        goToQueue();
        goOut();

    }

    @Override
    public String toString() {
        if (isPensioneer()){
            return this.getName() + "Pensioneer ";
        }
        else return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "начал выбирать товары");

        int timeout;
        if (pensioneer) {
            yield();
            timeout = Util.random(1500, 3000);
        } else {
            timeout = Util.random(2000);
        }
        Util.sleep(timeout);
        putGoodsToBucket();
        System.out.println(this + "выбрал товары");

    }


    @Override
    public void goOut() {
        System.out.println(this + "вышел из магазина");
        Dispathcher.buyerLeftMarket();
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" стал в очередь");
        QueueBuyers.addBuyer(this);
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this+" покинул очередь");
    }

    @Override
    public void takeBucket() {
        int timeout;
        bucket = new HashMap<>(4);
        if (pensioneer) {
            timeout = Util.random(150, 300);
        } else {
            timeout = Util.random(100, 200);
        }
        Util.sleep(timeout);
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBucket() {
        int countGoods = Util.random(1, 4);
        double totalSum = 0;
        for (int i = 1; i <= countGoods; i++) {
            int timeout;

            if (pensioneer) {
                timeout = Util.random(150, 300);
            } else {
                timeout = Util.random(100, 200);
            }
            Util.sleep(timeout);
            Map.Entry<String, Double> entry = Runner.takeGoods();
            if (entry != null) {
                bucket.put(entry.getKey(), entry.getValue());
                System.out.println(this + "кладет " + entry.getKey() + " стоимостью " + entry.getValue() + " BYN в корзину.");
                totalSum += entry.getValue();
            }
        }
        System.out.println("Общая сумма товаров у " + this + "= " +Math.round(totalSum*100)/100.0 + " BYN");


    }

    void setPensioneer(boolean pensioneer) {
        this.pensioneer = pensioneer;
    }
}
