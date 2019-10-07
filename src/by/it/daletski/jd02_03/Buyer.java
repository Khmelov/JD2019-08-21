package by.it.daletski.jd02_03;

class Buyer extends Thread implements IBuyer {

    private boolean waiting = false;

    void resetWaiting() {
        this.waiting = false;
    }

    Buyer() {
        //important!!!!
        super("Buyer № " + Dispatcher.buyerInMarket());
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
        Util.sleep(timeout);
        System.out.printf("\t%s end to choose goods\n", this);
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " added to Queue");
        QueueBuyers.add(this);
        waiting = true;
        synchronized (this) {
            while (waiting)
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
