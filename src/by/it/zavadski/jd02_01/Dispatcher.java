package by.it.zavadski.jd02_01;

import java.util.HashMap;

class Dispatcher {
    static int kSpeed =1000;
    static int closeTime =120; //Time of app running

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
