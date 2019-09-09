package by.it.zavadski.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TaskB1. Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
 * гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
 */
public class TaskB1 {
    //public static char[] vowels={'a','я','у','ю','э','е','ы','и','о','ё'};
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            if(correctWord(matcher.group().toLowerCase())){
                System.out.println(matcher.group());
            }
        }
    }

    /**
     * @author=y.zavadski
     * @param word - word for check.
     * @return return statement for condition of task: first consonant and the last is vowel.
     */
    private static boolean correctWord(String word){
        return isVowel(word.charAt(word.length() - 1)) && (!isVowel(word.charAt(0)));
    }

    /**
     * @author=y.zavadski
     * @param ch - character for check.
     * @return true if character corresponds conditions.
     */
    private static boolean isVowel(char ch){
        return ch == 'а' || ch == 'о' || ch == 'у' || ch == 'э' || ch == 'ы' || ch == 'я' || ch == 'ё' || ch == 'ю' || ch == 'е' || ch == 'и';
    }
}
//    private static void process(String word) {
//        for (char vowel : vowels) {
//            if (word.toLowerCase().charAt(0) != vowel && word.toLowerCase().charAt(word.length() - 1) == vowel) {
//                System.out.printf("%s\n", word);
//            }
//        }
//    }
//}
