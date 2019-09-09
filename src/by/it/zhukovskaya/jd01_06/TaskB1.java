package by.it.zhukovskaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp  = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = regexp.matcher(text);
        while(matcher.find()) {
            String word = matcher.group();
            if (isCorrectWord(word))
                System.out.println(word);
        }
    }

    private static boolean isCorrectWord(String word) {
        word = word.toLowerCase();
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length()-1);
        return isConsonantChar(startChar) && isVowelChar(endChar);
    }

    private static boolean isConsonantChar(char ch) {
        char [] consonantArray = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н',
                'п', 'р', 'с', 'т', 'ф', 'х', 'ц',  'ч', 'ш', 'щ' };
        for(char i: consonantArray)
            if (ch == i)
                return true;
        return false;
    }

    private static boolean isVowelChar(char  ch) {
        char [] vowelArray = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};
        for(char i: vowelArray)
            if (ch == i)
                return true;
        return false;
    }
}
