package by.it.rubatskii.jd02_03;

public interface IUseBasket {

    void takeBasket();            //взял корзину                           (от 0,1 до 0,2 секунд)

    void putGoodsToBasket();      //положил выбранный товар в корзину      (от 0,1 до 0,2 секунд)

    void returnBasket();          //поставил корзину обратно
}
