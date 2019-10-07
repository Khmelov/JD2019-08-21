package by.it.shamuradova.jd02_02;


import java.util.ArrayList;
import java.util.List;

import static by.it.shamuradova.jd02_02.Dispatcher.getCountOfBuyersInMarket;
import static by.it.shamuradova.jd02_02.Dispatcher.planComplete;

public class Shop {

    static double balance;

    List<Good> listOfGoods=new ArrayList<>();

    Shop(){
        System.out.println("Shop is open");
    }

    void addToList (Good g){
        listOfGoods.add(g);
    }

    boolean shopIsOpened(){
        return !planComplete() || getCountOfBuyersInMarket() > 0;
    }












}
