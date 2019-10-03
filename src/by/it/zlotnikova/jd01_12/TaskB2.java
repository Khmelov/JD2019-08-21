package by.it.zlotnikova.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        String[] round = {"One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten"};
        ArrayList<String> arrPeoples = new ArrayList<>(Arrays.asList(round));
        LinkedList<String> linkPeoples = new LinkedList<>(arrPeoples);

        System.out.println(arrPeoples);
        String name1 = process(arrPeoples);
        System.out.println(name1);

        System.out.println(linkPeoples);
        String name2 = process(linkPeoples);
        System.out.println(name2);
    }

    private static String process(ArrayList<String> peoples) {
        int count = 0;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (count % 2 != 0) {
                    it.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        int count = 0;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            while (it.hasNext()) {
                it.next();
                if (count % 2 != 0) {
                    it.remove();
                }
                count++;
            }
        }
        return peoples.get(0);
    }
}
