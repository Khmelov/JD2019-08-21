package by.it.yuntsevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {

        Pattern regexp = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            process(word);

        }
        printResult();
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counts[i]++;
                return;
            }


        }
        words = Arrays.copyOf(words, words.length + 1);
        counts = Arrays.copyOf(counts, counts.length + 1);
        words[words.length - 1] = word;
        counts[counts.length - 1] = 1;

    }

    private static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);

        }
    }
}