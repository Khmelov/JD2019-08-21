package by.it.kiturka.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String,Integer> wordsMap = countWordsInText();
        printMap(wordsMap);
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            String word = stringIntegerEntry.getKey();
            Integer counter = stringIntegerEntry.getValue();
            System.out.println(word + "=" + counter);
        }
    }

    private static Map<String,Integer> countWordsInText() {
        Scanner wordsScanner = new Scanner(System.in);
        Map<String, Integer> wordsMap = new HashMap<>();
        String word;
        String[] line;
        int overallWordCount = 0;
        while (wordsScanner.hasNextLine()) {
            line = wordsScanner.nextLine().split("[-:;,.!?—()/\" ]+");
            for (int i = 0; i < line.length; i++) {
                word = line[i];
                if (word.equals("end") && overallWordCount >= 100)
                    return wordsMap;
                overallWordCount++;
                //Если слово новое, добавить его с счетчиком 1
                if (!wordsMap.containsKey(word)) {
                    wordsMap.put(word, 1);
                }
                //Если слово уже встречалось, увеличить его счетчик на 1
                else {
                    int counter = wordsMap.get(word);
                    wordsMap.put(word, counter + 1);
                }
            }
        }
        return wordsMap;
    }
}