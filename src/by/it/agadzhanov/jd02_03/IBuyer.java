package by.it.agadzhanov.jd02_03;

public interface IBuyer {

    void enterToMarket();      //вошел в магазин            (мгновенно)

    void chooseGoods();        //выбрал товары              (от 0,5 до 2 секунд)

    void goToQueue();

    void goOut();              //отправился на выход        (мгновенно)

}
