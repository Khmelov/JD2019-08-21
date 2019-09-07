package by.it.rubatskii.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern regexp = Pattern.compile("[а-яёА-ЯЁ]{4,}");
        Matcher mather = regexp.matcher(text);
        while (mather.find()) {
            int start = mather.start();
            text.setCharAt(start + 3, '#');
            if (mather.group().length()>=7)
            text.setCharAt(start + 6, '#');

        }

        System.out.println(text);

    }
}
