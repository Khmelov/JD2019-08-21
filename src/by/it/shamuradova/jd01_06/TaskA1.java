package by.it.shamuradova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);

        //ппатерн, который описывает все слова русского языка
        //не подходят слова меньше 4 символов
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");

        //матчер на основе регулярного выражения будет пробегать по всем словам
        //Poem.text и попадать в те же самые позиции в StBuilder,
        // в которые эти слова встретились в тексте
        Matcher matcher = pattern.matcher(Poem.text); //метод matcher кл pattern возвращает объект, который может бежать по тексту


        //до тех пор, пока матчер что-то находит
        //означает, что внутри текста наткнулись на слово по очереди
        while (matcher.find()) {
            int start = matcher.start(); //матчер найденного слова возвращает число первой буквы
            sb.setCharAt(start + 3, '#');  //в нужную позицию устанавливает символ
            if (matcher.group().length() >= 7) {             //group возвращает слово
                sb.setCharAt(start + 6, '#');
            }
        }
        System.out.println(sb);

    }
}
