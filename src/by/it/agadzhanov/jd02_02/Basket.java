package by.it.agadzhanov.jd02_02;

import java.util.*;

class Basket {

    private static HashMap<String, Double> goodsInBasket;

    Basket() {
        goodsInBasket = new HashMap<>();
        int goodsNumber = Util.randomFromTo(1, Goods.goodsMap.size());
        List<String> goodsList = new ArrayList<>(Goods.goodsMap.keySet());
        for (int i = 1; i <= goodsNumber; i++) {
            int goodIndex = Util.randomUpTo(goodsList.size() - 1);
            goodsInBasket.put(goodsList.get(goodIndex), Goods.goodsMap.get(goodsList.get(goodIndex)));
            goodsList.remove(goodIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double totalMoneySpent = 0;
        String delimiter = "";
        for (Map.Entry<String, Double> goodInBasket : goodsInBasket.entrySet()) {
            sb.append(delimiter).append(goodInBasket.getKey()).append(" за ").append(goodInBasket.getValue()).append(" BYN");
            totalMoneySpent = totalMoneySpent + goodInBasket.getValue();
            delimiter = ", ";
        }
        sb.append(". Итого потрачено ").append(totalMoneySpent).append(" BYN");
        return sb.toString();
    }
}
