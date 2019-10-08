package by.it.krautsevich.jd02_04;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PrinterVar {

    void printVars (Map<String, Var> vars) {
        if (vars.isEmpty()) {
            System.out.println("Нет данных в памяти");}

        if (!vars.isEmpty()) {
            Set <Map.Entry<String , Var>> newSet = vars.entrySet() ;
            Iterator <Map.Entry<String , Var>> iter = newSet.iterator() ;
            while (iter.hasNext()) {
                Map.Entry<String , Var> me = iter.next() ;
                if (me.getKey() != null)
                System.out.println(me.getKey() + " = " + me.getValue());
            }
        }
    }

    void printSortedVars (Map<String, Var> vars) {
        TreeMap <String , Var> sorted = new TreeMap<>() ;
        Set <Map.Entry<String , Var>> newSet = vars.entrySet() ;
        Iterator <Map.Entry<String , Var>> iter = newSet.iterator() ;
        while (iter.hasNext()) {
            Map.Entry<String , Var> me = iter.next() ;
            sorted.put(me.getKey() , me.getValue()) ; }
        printVars(sorted);
    }

}
