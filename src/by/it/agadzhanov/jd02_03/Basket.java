package by.it.agadzhanov.jd02_03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Basket {

    private HashMap<String, Integer> goodsInBasket;
    private int totalMoneySpent = 0;
    private static final HashMap<String, Integer> goodsMap = new HashMap<>();

    static {
        goodsMap.put("хлеб", 1);
        goodsMap.put("сыр", 5);
        goodsMap.put("сахар", 3);
        goodsMap.put("чай", 10);
    }

    int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    private void setGoodsInBasket(HashMap<String, Integer> goodsInBasket) {
        this.goodsInBasket = goodsInBasket;
    }

    private void setTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }


    void fillBasket() {
        HashMap<String, Integer> goodsInBasket = new HashMap<>();
        int totalMoneySpent = 0;
        int goodsNumber = Util.randomFromTo(1, goodsMap.size());
        List<String> goodsList = new ArrayList<>(goodsMap.keySet());
        for (int i = 1; i <= goodsNumber; i++) {
            int goodIndex = Util.randomUpTo(goodsList.size() - 1);
            goodsInBasket.put(goodsList.get(goodIndex), goodsMap.get(goodsList.get(goodIndex)));
            totalMoneySpent = totalMoneySpent + goodsInBasket.get(goodsList.get(goodIndex));
            goodsList.remove(goodIndex);
        }
        setGoodsInBasket(goodsInBasket);
        setTotalMoneySpent(totalMoneySpent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = "";
        for (Map.Entry<String, Integer> goodInBasket : goodsInBasket.entrySet()) {
            sb.append(delimiter).append(goodInBasket.getKey()).append(" за ").append(goodInBasket.getValue()).append(" BYN");
            delimiter = ", ";
        }
        sb.append(". Итого потрачено ").append(totalMoneySpent).append(" BYN");
        return sb.toString();
    }
}
