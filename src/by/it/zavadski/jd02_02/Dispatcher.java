package by.it.zavadski.jd02_02;

import java.util.HashMap;

class Dispatcher {
    private static final Object monitorCounter=new Object();
    static int kSpeed =1000;
    static int closeTime =120; //Time of app running

    static final int MAX_BYERS=100;
    static int buyerCounter=0;
    static int buyersInMarket=0;

static boolean marketIsOpened(){
    return !planComplete() || buyersInMarket>0;
}

static int buyerInMarket(){
    synchronized (monitorCounter){
        buyerCounter++;
        buyersInMarket++;
    }
    return buyersInMarket;
}

static void buyerLeaveMarket(){
    synchronized (monitorCounter){
        buyersInMarket--;
    }
}

public static boolean planComplete(){
    return buyerCounter==MAX_BYERS;
}


    static HashMap<String,Double> availableGoods=new HashMap<String, Double>(){
        {
            put("Eggs",1.59);
            put("Potato",0.45);
            put("Tomato",4.99);
            put("Fish",12.57);
            put("Meat",9.25);
            put("Bread",1.00);
            put("Milk",1.50);
            put("Cheese",1.79);
            put("Chocolate",13.99);
            put("Noodles",2.89);
            put("Sugar",0.90);
            put("Salt",0.98);
        }
    };
    static HashMap <String,Double> chooseGoods(){
        return availableGoods;
    }


}
