package by.it.rojas.jd06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] increase = {};

    public static void main(String[] args) {
        String poem1 = Poem.text;
        String poem2 = poem1.replaceAll("\\.\\.\\.", "/");
        Pattern pattern = Pattern.compile("[^.?!]+");
        Matcher matcher = pattern.matcher(poem2);


        while (matcher.find()) {
            String sentences = matcher.group();
            int last = increase.length;
            increase = Arrays.copyOf(increase, last + 1);
            increase[last] = sentences;
        }

        for (int i = 0; i < increase.length; i++) {
            increase[i] = increase[i].replaceAll("[^а-яА-ЯЁё]+", " ");
            increase[i] = increase[i].trim();
        }
        for (int j = 0; j < increase.length-1; j++) {
            for (int i = 0; i < increase.length-1; i++) {
                if (increase[i].length() >= increase[i + 1].length()) {
                    String st = increase[i];
                    increase[i] = increase[i + 1];
                    increase[i + 1] = st;
                }
            }
        }
        for (String s : increase) {
            System.out.println(s);
        }
    }
}
