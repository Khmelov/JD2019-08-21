package by.it.boytsov.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        LinkedList<String> peopleLinked = new LinkedList<>();
        people.add("1");
        people.add("2");
        people.add("3");
        people.add("4");
        peopleLinked.add("1");
        peopleLinked.add("2");
        peopleLinked.add("3");
        peopleLinked.add("4");

        System.out.println(process(people));
        System.out.println(process(peopleLinked));
    }

    private static String process(ArrayList<String> peoples) {
        int count = 0;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) {
                    it.remove();
                }
            }
        }
        return peoples.get(0);
    }
    private static String process(LinkedList<String> peoples){
        int count = 0;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 2 == 0) {
                    it.remove();
                }
            }
        }
        return peoples.get(0);
    }
}



