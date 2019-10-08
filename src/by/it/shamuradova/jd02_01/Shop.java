package by.it.shamuradova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Good> listOfProducts = new ArrayList<>();

    public void addToList(Good product){
        listOfProducts.add(product);
    }
}
