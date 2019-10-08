package by.it.agadzhanov.jd02_02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Basket {

    private static HashMap<String, Double> goodsInBasket;
    private static final HashMap<String, Double> goodsMap = new HashMap<>();

    static {
        goodsMap.put("хлеб", 1.0);
        goodsMap.put("сыр", 2.0);
        goodsMap.put("сахар", 1.5);
        goodsMap.put("чай", 0.5);
    }

    Basket() {
        goodsInBasket = new HashMap<>();
        int goodsNumber = Util.randomFromTo(1, goodsMap.size());
        List<String> goodsList = new ArrayList<>(goodsMap.keySet());
        for (int i = 1; i <= goodsNumber; i++) {
            int goodIndex = Util.randomUpTo(goodsList.size() - 1);
            goodsInBasket.put(goodsList.get(goodIndex), goodsMap.get(goodsList.get(goodIndex)));
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
