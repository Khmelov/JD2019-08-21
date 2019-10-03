package by.it.zlotnikova.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        int initialCapacity = 4096;
        ArrayList<String> arrPeoples = new ArrayList<>(initialCapacity);

        Random rnd = new Random();
        for (int i = 0; i < initialCapacity; i++) {
            arrPeoples.add(String.valueOf(rnd.nextInt(100)));
        }
        LinkedList<String> linkPeoples = new LinkedList<>(arrPeoples);
        LinkedList<String> linkPeoples2 = new LinkedList<>(arrPeoples);

        long initTime1 = System.currentTimeMillis();
        String name1 = process(arrPeoples);
        long time1 = System.currentTimeMillis() - initTime1;
        System.out.println("Time for ArrayList - " + time1 + "ms");
        System.out.println(name1);

        long initTime2 = System.currentTimeMillis();
        String name2 = process(linkPeoples);
        long time2 = System.currentTimeMillis() - initTime2;
        System.out.println("Time for LinkedList - " + time2 + "ms");
        System.out.println(name2);

        long initTime3 = System.currentTimeMillis();
        String name3 = processOther(linkPeoples2);
        long time3 = System.currentTimeMillis() - initTime3;
        System.out.println("Time for Queue - " + time3 + "ms");
        System.out.println(name3);
    }

    private static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (count % 2 == 0) {
                    it.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (count % 2 == 0) {
                    it.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    private static String processOther(LinkedList<String> peoples) {
        Queue<String> queue = peoples;
        int count = 1;
        String element;
        while (queue.size() > 1) {
            element = queue.remove();
            if (count % 2 != 0) {
            queue.add(element);
            }
            count++;
        }
        return queue.element();
    }
}