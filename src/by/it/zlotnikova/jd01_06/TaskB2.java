package by.it.zlotnikova.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        String poem = Poem.text;
        poem = poem.replaceAll("\\.\\.\\.", "~");
        String[] sentences = poem.split("\\.|\\?|!");

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ");
            sentences[i] = sentences[i].trim();
        }

        Arrays.sort(sentences, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}