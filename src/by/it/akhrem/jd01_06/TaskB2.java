package by.it.akhrem.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern regexp  = Pattern.compile("[.]+");
        //Pattern regexp = Pattern.compile("[.!?]+");
        String[] sentences = regexp.split(Poem.text);
        Pattern regexp1 = Pattern.compile("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < sentences.length; i++) {
            Matcher matcher = regexp1.matcher(sentences[i]);
            sentences[i] = matcher.replaceAll(" ");
            sentences[i] = sentences[i].trim();
        }

        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++)
                if (sentences[i].length() > sentences[j].length()) {
                    String temp = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = temp;
                }
        }
       for (int i = 0; i < sentences.length; i++) {
            System.out.println(sentences[i]);
        }


    }
}
