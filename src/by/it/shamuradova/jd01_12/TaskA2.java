package by.it.shamuradova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {//объединение множеств
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        return union;
    }
    static Set<Integer>  getCross (Set<Integer> a, Set<Integer> b) {//пересечение множеств
        Set<Integer> cross = new HashSet<>(a);
        cross.retainAll(b);
        return cross;
    }

    public static void main(String[] args) {
        Integer[] a1 = new Integer[]{1, 2, 5, 8, 10, 5, 6};
        Integer[] b1 = new Integer[]{2, 5, 6, 7, 9, 2, 6, 10};
        Set<Integer> a = new HashSet<>(Arrays.asList(a1));
        Set<Integer> b = new TreeSet<>(Arrays.asList(b1));
        System.out.println(a);
        System.out.println(b);
        System.out.println(getUnion(a, b));
        System.out.println(getCross(a,b));

    }
}
