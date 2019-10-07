package by.it.yuntsevich.jd02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Goods {

    private static Map<String, Double> goods = new HashMap<>(20);

    static Map.Entry<String, Double> takeGoods() {
        goods.put("Гречка", 1.0);
        goods.put("Сахар", 0.99);
        goods.put("Хлеб", 0.8);
        goods.put("Огурец", 3.6);
        goods.put("Молоко", 2.0);
        goods.put("Курица", 8.6);
        goods.put("Капуста", 0.68);
        goods.put("Макароны", 2.9);
        goods.put("Картофель", 0.86);
        goods.put("Мука", 1.57);
        Set<Map.Entry<String, Double>> entries = goods.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        int number = Util.random(1, goods.size());
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            if (i == number)
                return iterator.next();
            else iterator.next();
        }
        return null;
    }

    static double getPrice(String good){
        return goods.get(good);
    }
}
