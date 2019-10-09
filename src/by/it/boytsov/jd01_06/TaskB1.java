package by.it.boytsov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1
{
    public static void main(String[] args)
    {

        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern  = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(stringBuilder);
        while(matcher.find())
        {
            String word = matcher.group();
            if (isWord(word))
                System.out.println(word);
        }
    }

    private static boolean isWord(String word)
    {
        word = word.toLowerCase();
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length()-1);
        return consChar(startChar) && vowChar(endChar);
    }

    private static boolean consChar(char ch)
    {
        char [] consonantArray = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н',
                'п', 'р', 'с', 'т', 'ф', 'х', 'ц',  'ч', 'ш', 'щ' };
        for(char i: consonantArray)
            if (ch == i)
                return true;
        return false;
    }

    private static boolean vowChar(char  ch) {
        char [] vowelArray = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};
        for(char i: vowelArray)
            if (ch == i)
                return true;
        return false;
    }
}
