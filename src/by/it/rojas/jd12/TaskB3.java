package by.it.rojas.jd12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    private static String process(ArrayList<String> peoples) {

        int count = 0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size() > 1) {
            if(it.hasNext()) {
                it.next();
                count++;
                if(count == 2) {
                    it.remove();
                    count = 0;
                }
            }
            else {
                it = peoples.iterator();
            }
        }
        return peoples.toString().replaceAll("\\[","").replaceAll("]","");
    }



    private static String process(LinkedList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size() > 1) {
            if(it.hasNext()) {
                it.next();
                count++;
                if(count == 2) {
                    it.remove();
                    count = 0;
                }
            }
            else {
                it = peoples.iterator();
            }
        }
        return peoples.toString().replaceAll("\\[","").replaceAll("]","");
    }

    private static String processNEW(LinkedList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while(peoples.size() > 1) {
            if(it.hasNext()) {
                it.next();
                count++;
                if(count == 2) {
                    it.remove();
                    count = 0;
                }
            }
            else {

                it = peoples.iterator();
            }
        }
        return peoples.toString().replaceAll("[\\[\\]]","");
    }
    public static void main(String[] args) {
        ArrayList <String> people = new ArrayList<>();
        LinkedList<String> peoples = new LinkedList<>();
        LinkedList<String> peoplesnew = new LinkedList<>();

        for (int i = 0; i < 4096; i++) {
            people.add("Cemen "+i);
            peoples.add("Cemen "+i);
            peoplesnew.add("Cemen "+i);

        }
        long startTime = System.nanoTime();
        System.out.println(process(people));
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Array "+elapsedTime);

        startTime = System.nanoTime();
        System.out.println(process(peoples));
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println("Linked "+elapsedTime);

        startTime = System.nanoTime();
        System.out.println(processNEW(peoplesnew));
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println("LinkedNEW "+elapsedTime);
    }
}
