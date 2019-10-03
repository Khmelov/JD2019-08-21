package by.it.rojas.jd12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

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
    public static void main(String[] args) {

        ArrayList <String> people = new ArrayList<>();
        people.add("Семен 1");people.add("Семен 2");people.add("Семен 3");
        people.add("Семен 4");people.add("Семен 5");people.add("Семен 6");
        System.out.println(process(people));
        LinkedList<String> peoples = new LinkedList<>();
        peoples.add("Семен 1");peoples.add("Семен 2");peoples.add("Семен 3");
        peoples.add("Семен 4");peoples.add("Семен 5");peoples.add("Семен 6");
        System.out.println(process(peoples));
    }
}
