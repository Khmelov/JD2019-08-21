package by.it.kiturka.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {
        double slowTimeStart = System.currentTimeMillis();
        String testStringSlow = slow(Poem.text);
        double slowTime = System.currentTimeMillis() - slowTimeStart;

        System.out.println(testStringSlow);
        System.out.println(slowTime);

        double fastTimeStart = System.currentTimeMillis();
        String testStringFast = fast(Poem.text);
        double fastTime = System.currentTimeMillis() - fastTimeStart;

        System.out.println(testStringFast);
        System.out.println(fastTime);
    }

    private static String slow(String text) {
        Pattern wordsPattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher wordsMatcher = wordsPattern.matcher(text);
        String[] words = new String[0];

        // Создать массив из уникальных слов
        while (wordsMatcher.find()) {
            String word = wordsMatcher.group();
            boolean wordFlag = false;

            // Определить, встречалось слово или нет (true - встречалось, false - не встречалось)
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    wordFlag = true;
                    break;
                }
            }

            // Если встречалось, ничего не делать, если нет - добавить в конец массива
            if (!wordFlag) {
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = word;
            }
        }

        // Создать длинную строку из случайных слов массива
        String veryLongString = "";
        Random wordGenerator = new Random(0);
        while (veryLongString.length() < 100000) {
            int index = wordGenerator.nextInt(words.length);
            veryLongString = veryLongString.concat(words[index]).concat(" ");
        }
        return veryLongString;
    }

    private static String fast(String text) {
        Pattern wordsPattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher wordsMatcher = wordsPattern.matcher(text);
        String[] words = new String[0];

        // Создать массив из уникальных слов
        while (wordsMatcher.find()) {
            String word = wordsMatcher.group();
            boolean wordFlag = false;

            // Определить, встречалось слово или нет (true - встречалось, false - не встречалось)
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    wordFlag = true;
                    break;
                }
            }

            // Если встречалось, ничего не делать, если нет - добавить в конец массива
            if (!wordFlag) {
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = word;
            }
        }

        // Создать длинную строку из случайных слов массива
        StringBuilder veryLongStringBuilder = new StringBuilder();
        Random wordGenerator = new Random(0);
        while (veryLongStringBuilder.length() < 100000) {
            int index = wordGenerator.nextInt(words.length);
            veryLongStringBuilder.append(words[index]).append(" ");
        }
        return veryLongStringBuilder.toString();
    }
}