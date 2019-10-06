package by.it.shamuradova.jd01_12;

import by.it.akhmelev.jd01_11.ListA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> listOfGrades= new ArrayList<>();

    private void clearBad(List<Integer>grades){
        Iterator <Integer> iterator=grades.iterator();
        while(iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4){
                iterator.remove();
            }
        }
    }

    static void printList(List<Integer> grade){
        System.out.println(grade);
    }

    public static void main(String[] args) {

        TaskA1 a1= new TaskA1();

        Random random=new Random();
        for(int i=0; i<10; i++){
            int ocenka=random.nextInt(10)+1;
            a1.listOfGrades.add(ocenka);
        }
        printList(a1.listOfGrades);
        a1.clearBad(a1.listOfGrades);
        printList(a1.listOfGrades);
    }
}
