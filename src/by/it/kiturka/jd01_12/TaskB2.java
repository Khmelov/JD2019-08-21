package by.it.kiturka.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        String[] peopleArray = {"1","2","3","4","5","6","7","8","9"};
        ArrayList<String> peopleArrayList = new ArrayList<>(Arrays.asList(peopleArray));
        LinkedList<String> peopleLinkedList = new LinkedList<>(Arrays.asList(peopleArray));

        String remaining1 = process(peopleArrayList);
        System.out.println("Оставшийся человек - это " + remaining1);
        String remaining2 = process(peopleLinkedList);
        System.out.println("Оставшийся человек - это " + remaining2);
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
