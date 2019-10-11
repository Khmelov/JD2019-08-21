package by.it.boytsov.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Basket {

    private HashMap<String, Integer> goodsInBasket;
    private int totalMoneySpent = 0;
    private static final HashMap<String, Integer> goodsMap = new HashMap<>();

    static {
        goodsMap.put("milk", 2);
        goodsMap.put("cheese", 7);
        goodsMap.put("apple", 1);
        goodsMap.put("bread", 1);
    }

    int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    private void setTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }
    private void setGoodsInBasket(HashMap<String, Integer> goodsInBasket) {
        this.goodsInBasket = goodsInBasket;
    }
    Basket() {
        HashMap<String, Integer> goodsInBasket = new HashMap<>();
        int totalMoneySpent = 0;
        int goodsNumber = Util.randomFromTo(1, goodsMap.size());
        List<String> goodsList = new ArrayList<>(goodsMap.keySet());
        for (int i = 1; i <= goodsNumber; i++) {
            int goodIndex = Util.randomUpTo(goodsList.size() - 1);
            goodsInBasket.put(goodsList.get(goodIndex), goodsMap.get(goodsList.get(goodIndex)));
            totalMoneySpent=totalMoneySpent+goodsInBasket.get(goodsList.get(goodIndex));
            goodsList.remove(goodIndex);
        }
        setGoodsInBasket(goodsInBasket);
        setTotalMoneySpent(totalMoneySpent);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        double totalMoneySpent = 0;
        String delimiter = "";
        for (Map.Entry<String, Integer> goodInBasket : goodsInBasket.entrySet()) {
            stringBuilder.append(delimiter).append(goodInBasket.getKey()).append(" for ").append(goodInBasket.getValue()).append(" $");
            totalMoneySpent = totalMoneySpent + goodInBasket.getValue();
            delimiter = ", ";
        }
        stringBuilder.append(". Total ").append(totalMoneySpent).append(" $");
        return stringBuilder.toString();
    }
}