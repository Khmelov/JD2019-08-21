package by.it.gorevoy.jd01_12;

import java.util.*;

public class TaskB3 {


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of people");
        int number=scanner.nextInt();
        for (int i = 0; i <number ; i++) {
            arrayList.add("Person"+(i+1));
            linkedList.add("Person"+(i+1));
        }
        System.out.println(arrayList);
        System.out.println(process(arrayList));
        System.out.println(linkedList);
        System.out.println(process(linkedList));

    }

    static String process(ArrayList<String> peopleArr) {
        int counter = 1;
        while (peopleArr.size() != 1) {
            Iterator<String> iterator = peopleArr.iterator();
            while (iterator.hasNext()) {
                if (counter % 2 == 0) {
                    iterator.next();
                    iterator.remove();
                    counter++;
                } else {
                    iterator.next();
                    counter++;
                }
            }
        }
        return peopleArr.get(0);
    }

    static String process(LinkedList<String> people) {
        int counter = 1;
        while (people.size() != 1) {
            ListIterator<String> iterator = people.listIterator();
            while (iterator.hasNext()) {
                if (counter % 2 == 0) {
                    iterator.next();
                    iterator.remove();
                    counter++;//
                } else {
                    iterator.next();
                    counter++;
                }
            }
        }
        return people.getFirst();
    }
}