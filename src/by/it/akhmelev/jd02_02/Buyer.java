package by.it.akhmelev.jd02_02;

import java.util.HashSet;
import java.util.Set;

class Buyer extends Thread implements IBuyer {

    Buyer() {
        //important!!!!
        super("Buyer № " + Dispatcher.buyerInMarket());
    }

    private Set<Good> backet = new HashSet<>();

    public Set<Good> getBacket() {
        return backet;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market >>>");
    }

    @Override
    public void chooseGoods() {
        System.out.printf("\t%s started to choose goods\n", this);
        int timeout = Util.random(2000);
        int count = Util.random(1, 4);
        while (backet.size() < count) {
            backet.add(GoodTable.getRandom());
        }
        Util.sleep(timeout);
        System.out.printf("\t%s end to choose goods\n", this);
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " added to Queue");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " leave CashDesk");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leave the Market <<<");
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
