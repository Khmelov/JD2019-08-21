package by.it.shamuradova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Good> listOfProducts=new ArrayList<>();
    void addGoods(Good good){
        listOfProducts.add(good);
    }
}
