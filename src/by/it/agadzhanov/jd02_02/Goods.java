package by.it.agadzhanov.jd02_02;

import java.util.HashMap;

class Goods {

    static final HashMap<String, Double> goodsMap = new HashMap<>();

    static {
        goodsMap.put("хлеб", 1.0);
        goodsMap.put("сыр", 2.0);
        goodsMap.put("сахар", 1.5);
        goodsMap.put("чай", 0.5);
    }
}
