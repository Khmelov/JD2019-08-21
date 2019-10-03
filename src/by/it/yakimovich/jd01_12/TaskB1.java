package by.it.yakimovich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String,Integer> corpus=new HashMap<>();
        Scanner scan =new Scanner(System.in);
        getWords(scan,corpus);
        print(corpus);
    }
    private static void print(Map<String, Integer> corpus) {
        System.out.println(corpus);
    }
    private static void getWords(Scanner scan, Map<String, Integer> corpus) {
        String enteredWord;
        String[] words;
        int index = 0;
        while (!(enteredWord = scan.next()).equals("end")) {
            words=enteredWord.replace("isn't","don't").replaceAll("[,.;:]","").split(" ");
            wordsCount(words,corpus);
        }
    }
    private static void wordsCount(String[] words, Map<String, Integer> corpus) {
        for (String word : words) {
            if(corpus.containsKey(word)){
                int count=corpus.get(word);
                corpus.replace(word,++count);
            }else{
                corpus.put(word,1);
            }
        }

    }
}
