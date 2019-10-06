package by.it.yakimovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getCross (Set<Integer> one, Set<Integer> two ){
        Set<Integer> result=new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    private static Set<Integer> getUnion (Set<Integer> one, Set<Integer> two ){
        Set<Integer> result=new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet= new TreeSet<>(Arrays.asList(1,2,4,5,5,6,6,7));
        HashSet<Integer> hashSet= new HashSet<>(Arrays.asList(8,8,6,7,6,45,2,1,2));
        System.out.println(getCross(treeSet, hashSet));
        System.out.println(getUnion(treeSet, hashSet));
    }
}
