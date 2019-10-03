package by.it.kiturka.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,4,4,5,5,6,6));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(9,8,7,4,4,4,5,5,6,6));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }

    private static Set<Integer> getUnion(Set<Integer> one,Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        Iterator<Integer> iterator = two.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            result.add(value);
        }
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one,Set<Integer> two) {
        Set<Integer> result = new HashSet<>();
        Iterator<Integer> iterator = one.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (two.contains(value))
                result.add(value);
        }
        return result;
    }
}
