package by.it.shamuradova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

   //создание пустого массива для слов и массива счетчиков, сколько слов, столько и счетчиков
   private static String [] words = new String [0];
   private static int [] counts = new int [0];


   //метод, который по заданному слову определяет его позицию в массиве words
    private static void process(String word){
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word)){
                counts[i]++;
                return;
            }
        }
        //такого слова нет
        words = Arrays.copyOf(words, words.length + 1);//
        // копируем массив words и вставляем его в этот же массив больше размером для нового слова
        counts = Arrays.copyOf(counts, counts.length+1);
        words[words.length-1]=word;//записываем само слово на последнюю позицию индекса
        counts[counts.length-1]=1;
    }
    private static void printResult(){
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);
        }
    }


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(("[a-яА-ЯёЁ]+"));
        Matcher matcher=pattern.matcher(Poem.text);

        //цикл, который перебирает все слова в поэме
        while(matcher.find()){
            //найдем сначало само слово
            String word=matcher.group();
            process(word);
        }
        printResult();


    }


}
