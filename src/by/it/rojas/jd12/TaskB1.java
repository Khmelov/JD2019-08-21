package by.it.rojas.jd12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        String s;
        while (!(s = sc.next()).equals("end")) {
            s = s.replaceAll("[^a-zA-Z' +]", "");
            String[] a = s.split("^a-zA-Z'+");
            for (String str : a) {
                if (words.containsKey(str)) {
                    words.put(str, words.get(str) + 1);
                } else {
                    words.put(str, 1);
                }
            }
        }
        System.out.println(words);
    }
}
