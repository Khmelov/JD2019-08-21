package by.it.shamuradova.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (; ; ) {
            String word = sc.next();

            if (word.equals("end")) {
                break;
            }
            list.add(word.replaceAll("[,\\.!?:;]", ""));
        }

        kolichestvoSlov(list);
    }

    private static void kolichestvoSlov(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        Set<String> wordsInString = wordCount.keySet();
        for (String word : wordsInString) {
            System.out.println(word + "=" + wordCount.get(word));
        }
    }

}
