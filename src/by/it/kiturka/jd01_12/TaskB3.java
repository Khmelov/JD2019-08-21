package by.it.kiturka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> peopleArrayList = new ArrayList<>();
        LinkedList<String> peopleLinkedList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            peopleArrayList.add(Integer.toString(i));
            peopleLinkedList.add(Integer.toString(i));
        }

        double startTime1 = System.nanoTime();
        String remaining1 = process(peopleArrayList);
        double time1 = System.nanoTime() - startTime1;
        System.out.println("Оставшийся человек - это " + remaining1 + "\nВыполнено за " + time1/1000 + " микросекунд");

        double startTime2 = System.nanoTime();
        String remaining2 = process(peopleLinkedList);
        double time2 = System.nanoTime() - startTime2;
        System.out.println("Оставшийся человек - это " + remaining2 + "\nВыполнено за " + time2/1000 + " микросекунд");
    }

    private static String process(ArrayList<String> peoples) {
        int counter = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                if (counter % 2 == 0) {
                    iterator.next();
                    iterator.remove();
                    counter++;
                }
                else {
                    iterator.next();
                    counter++;
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        int counter = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                if (counter % 2 == 0) {
                    iterator.next();
                    iterator.remove();
                    counter++;
                }
                else {
                    iterator.next();
                    counter++;
                }
            }
        }
        return peoples.get(0);
    }
}
