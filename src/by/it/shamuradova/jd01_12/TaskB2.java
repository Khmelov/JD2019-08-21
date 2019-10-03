package by.it.shamuradova.jd01_12;

import org.omg.CORBA.CharSeqHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    static String process(ArrayList<String> people) {
        int counter = 1;
        while (people.size() > 1) {
            for (Iterator<String> it = people.iterator(); it.hasNext(); ) {
                it.next();
                if (counter % 2 == 0) {
                    it.remove();
                }
                counter++;
            }
        }
        String person = people.get(0);
        return person;
    }

    static String process(LinkedList<String> people) {
        int counter = 1;
        while (people.size() > 1) {
            for (Iterator<String> it = people.iterator(); it.hasNext(); ) {
                it.next();
                if (counter % 2 == 0) {
                    it.remove();
                }
                counter++;
            }
        }
        String person = people.get(0);
        return person;
    }

    public static class Timer{
        private long iniTime; // время начала
        private Double Delta;
        public Timer(){
            iniTime=System.nanoTime();
        }
        public String toString(){
            Delta = (double)(System.nanoTime()- iniTime)/1000;
            return "Прошло " + Delta.toString()+" микросекунд.";
        }
    }

}


