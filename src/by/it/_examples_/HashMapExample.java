package by.it._examples_;

import java.util.*;

public class HashMapExample {

    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            map.put(i, "value" + i);
        }

        int count = 0;
        ArrayDeque<Map.Entry<Integer, String>> q = new ArrayDeque<>(map.entrySet());
        while (count < 15) {
            Map.Entry<Integer, String> pair = q.pollFirst();
            System.out.println(pair);
            count++;
            q.addLast(pair);
        }
    }

}


