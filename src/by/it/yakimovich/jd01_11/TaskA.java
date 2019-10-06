package by.it.yakimovich.jd01_11;

import java.util.List;

public class TaskA {

    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("Привет1");
        list.add("Привет2");
        list.add("Привет3");
        list.add("Привет4");
        list.add("Привет5");
        list.add("Привет6");
        list.add("Привет7");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }

}
