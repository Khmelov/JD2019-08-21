package by.it.gorevoy.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
//        checkA();
//        checkB();
//        checkC();
    }

    private static void checkA() {
        List<String> myListA = new ListA<>();
        List<String> arrListA = new ArrayList<>();
        myListA.add("One");
        arrListA.add("One");
        myListA.add("Two");
        arrListA.add("Two");
        myListA.add("Four");
        arrListA.add("Four");
        System.out.println(myListA.toString());
        System.out.println(arrListA.toString());
        myListA.add(2, "Three");
        arrListA.add(2, "Three");
        System.out.println(myListA.toString());
        System.out.println(arrListA.toString());
        myListA.remove(2);
        arrListA.remove(2);
        System.out.println(myListA.toString());
        System.out.println(arrListA.toString());
        myListA.remove("Two");
        arrListA.remove("Two");
        System.out.println(myListA.toString());
        System.out.println(arrListA.toString());
        System.out.println(myListA.get(0));
        System.out.println(arrListA.get(0));
    }

    private static void checkB() {
        List<String> myListB = new ListB<>();
        List<String> arrListB = new ArrayList<>();
        myListB.add("One");
        arrListB.add("One");
        myListB.add("Two");
        arrListB.add("Two");
        myListB.add("Four");
        arrListB.add("Four");
        System.out.println(myListB.toString());
        System.out.println(arrListB.toString());
        myListB.remove(1);
        arrListB.remove(1);
        System.out.println(myListB.toString());
        System.out.println(arrListB.toString());
        System.out.println(myListB.get(0));
        System.out.println(arrListB.get(0));
        myListB.set(0, "First");
        arrListB.set(0, "First");
        System.out.println(myListB.toString());
        System.out.println(arrListB.toString());
        myListB.add(1, "Second");
        arrListB.add(1, "Second");
        System.out.println(myListB.toString());
        System.out.println(arrListB.toString());
        List<String> list = Arrays.asList("Five", "Six", "Seven", "Eight");
        myListB.addAll(list);
        arrListB.addAll(list);
        System.out.println(myListB.toString());
        System.out.println(arrListB.toString());
    }

    private static void checkC() {
        Set<String> hashSet = new HashSet<>();
        Set<String> mySet = new SetC<>();
        mySet.add("One"); hashSet.add("One");
        mySet.add("Two"); hashSet.add("Two");
        mySet.add("Three"); hashSet.add("Three");
        mySet.add("One"); hashSet.add("One");
        mySet.add("Four"); hashSet.add("Four");
        System.out.println("  My set: " + mySet.toString());
        System.out.println("Hash set: " + hashSet.toString());


    }

}