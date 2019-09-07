package by.it.liukhtenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    static String[] massent = {};

    public static void main(String[] args) {
        String poem1 = new String(Poem.text);
        String poem2 = poem1.replaceAll("\\.\\.\\.", "/");
        // System.out.println(poem2);
        Pattern pattern = Pattern.compile("[^\\.\\?!]+");
        Matcher matcher = pattern.matcher(poem2);


        while (matcher.find()) {
            String sentences = matcher.group();
            //  System.out.println(sentences);
            int last = massent.length;
            massent = Arrays.copyOf(massent, last + 1);
            massent[last] = sentences;


        }
        //  System.out.println(Arrays.toString(massent));
        for (int i = 0; i < massent.length; i++) {
            massent[i] = massent[i].replaceAll("[^а-яА-ЯЁё]+", " ");
          /*  massent[i] = massent[i].replaceAll(":", " ");
            massent[i] = massent[i].replaceAll(" - ", " ");
            massent[i] = massent[i].replaceAll("/", " ");
            massent[i] = massent[i].replaceAll("\n", " ");
            massent[i] = massent[i].replaceAll(",", " ");*/
            massent[i] = massent[i].trim();
        }
        // System.out.println(Arrays.toString(massent));
        for (int j = 0; j < massent.length-1; j++) {
            for (int i = 0; i < massent.length-1; i++) {
                if (massent[i].length() >= massent[i + 1].length()) {
                    String st = massent[i];
                    massent[i] = massent[i + 1];
                    massent[i + 1] = st;

                }
            }
        }
        for (int i = 0; i < massent.length; i++) {
            System.out.println(massent[i]);
        }
       // System.out.println(Arrays.toString(massent));

    }
}