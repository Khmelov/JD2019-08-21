package by.it.yuntsevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] vowels = {'а', 'о', 'у', 'ы', 'э', 'я', 'ё', 'ю', 'и', 'е','А', 'О', 'У', 'Ы', 'Э', 'Я', 'Ё', 'Ю', 'И', 'Е'};
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();
            checkPrint(word);
        }
    }

    private static void checkPrint(String word) {
        boolean isFirstFound = true;
        boolean isLastFound = false;
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);

        for (char vowel : vowels) {
            if (word.length() <= 1) continue;
            if (first == vowel)
                isFirstFound = false;

            if (last == vowel)
                isLastFound = true;
        }
            if ( isFirstFound&&isLastFound)
                System.out.println(word);
        }
}
