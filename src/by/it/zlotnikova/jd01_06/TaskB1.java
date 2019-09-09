package by.it.zlotnikova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (check(matcher.group())) {
                System.out.println(matcher.group());
            }
        }
    }

    private static boolean check(String word) {
        if (word.length() <= 2) {
            return false;
        }
        String[] voices = {"а", "о", "и", "е", "ё", "э", "ы", "у", "ю", "я",
                "А", "О", "И", "Е", "Ё", "Э", "Ы", "У", "Ю", "Я"};
        for (int i = 0; i < voices.length; i++) {
            if (Character.toString(word.charAt(0)).equals(voices[i])) {
                return false;
            }
        }
        for (int j = 0; j < voices.length; j++) {
            if (Character.toString(word.charAt(word.length() - 1)).equals(voices[j])) {
                return true;
            }
        }
        return false;
    }
}
