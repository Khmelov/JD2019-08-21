package by.it.akhmelev.jd02_01;

class Buyer extends Thread implements IBuyer {


    Buyer(int number) {
        super("Buyer № " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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
    public void goOut() {
        System.out.println(this + " leave the Market <<<");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
