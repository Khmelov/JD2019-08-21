package by.it.boytsov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1
{

    public static void main(String[] args)
    {
        StringBuilder stringBuilder = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find())
        {
            int start=matcher.start();
            stringBuilder.setCharAt(start + 3,'#');

            if (matcher.group().length()>=7)
                stringBuilder.setCharAt(start + 6, '#');
        }
        System.out.println(stringBuilder);
    }
}
