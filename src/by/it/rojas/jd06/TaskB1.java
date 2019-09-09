package by.it.rojas.jd06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (Checkword (word)){
                System.out.println(word);
            }
        }
    }
    private static final String glasn = "ёуеаоэяиюыУЁЕЫАОЭЯИЮ";
    private static boolean Checkword(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        return  !Checkchar(first) && Checkchar(last);
    }

    private static boolean Checkchar(char ch) {
        return glasn.indexOf(ch)>=0;
    }
}
