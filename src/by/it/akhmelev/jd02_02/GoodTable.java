package by.it.akhmelev.jd02_02;

import by.it.akhmelev.jd02_05.User;

import java.util.ArrayList;
import java.util.List;

class GoodTable {

    static private List<Good> list=new ArrayList<>();
    static {
        list.add(new Good("Хлеб",1));
        list.add(new Good("Вода",0.5));
        list.add(new Good("Сахар",1.5));
        list.add(new Good("Соль",0.1));
        list.add(new Good("Масло",4.1));
    }

    static Good getRandom(){
        return list.get(Util.random(4));
    }

}
