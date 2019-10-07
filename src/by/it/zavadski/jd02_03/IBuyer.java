package by.it.zavadski.jd02_03;

public interface IBuyer {
        void enterToMarket();
        void jumpInQueue() throws InterruptedException;
        void chooseGoods();
        void goOut();
    }
