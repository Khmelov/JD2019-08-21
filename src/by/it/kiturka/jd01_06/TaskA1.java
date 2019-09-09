package by.it.kiturka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(Poem.text); /* Создадим StringBuilder в котором будем размещать поэму при ее обработке.
                                                                        И в параметры конструктора передаем наш файл */

        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}"); // + означает, что данная конструкция будет повторяться один или более раз
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            int start =  matcher.start();
            stringBuilder.setCharAt(start+3,'#');
            if (matcher.group().length()>=7){
                stringBuilder.setCharAt(start+6, '#');
            }
        }
        System.out.println(stringBuilder);
    }

    }

