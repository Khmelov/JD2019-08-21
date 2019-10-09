package by.it.boytsov.jd01_11;


import java.util.ArrayList;
import java.util.List;

public class Runner
{
    public static void main(String[] args) {

        List<String> myList2 = new ListB<>();
        List<String> arList2 = new ArrayList<>();
        List<String> plus = new ArrayList<>();
        plus.add("size");
        plus.add("newMark");
        myList2.add("123");
        myList2.add("two");
        myList2.add("three");
        myList2.add("4our");
        myList2.addAll(plus);
        arList2.add("123");
        arList2.add("two");
        arList2.add("three");
        arList2.add("4our");
        arList2.addAll(plus);
        System.out.println(myList2);
        System.out.println(arList2);
    }
}
