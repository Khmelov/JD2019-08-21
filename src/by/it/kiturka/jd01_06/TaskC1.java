package by.it.kiturka.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static String[] lineArray = new String[0];
    private static int maxLineLength = 0;

    public static void main(String[] args) {
        String poem = Poem.text;
        Pattern line = Pattern.compile(".+");
        Matcher matcherLine = line.matcher(poem);

        // Поместить все строки стихотворения в массив
        while (matcherLine.find()) {
            String oneLine = matcherLine.group();
            int last = lineArray.length;
            lineArray = Arrays.copyOf(lineArray, last + 1);
            lineArray[last] = oneLine;
        }

        // Найти самую длинную строку в массиве
        for (int i = 0; i < lineArray.length; i++) {
            if (lineArray[i].length() > maxLineLength) {
                maxLineLength = lineArray[i].length();
            }
        }

        // Выровнять все строки по длине самой длинной
        for (int i = 0; i < lineArray.length; i++) {
            addSpaces(lineArray[i], i);
        }

        // Напечатать полученные строки
        for (int i = 0; i < lineArray.length; i++) {
            System.out.println(lineArray[i]);
        }
    }

    private static void addSpaces(String line, int position) {
        int symbolCounter = 0;
        Pattern space = Pattern.compile(" +");

        // Пока длина строки не достигла максимальной
        while (line.length() < maxLineLength) {
            Matcher spaceMatcher = space.matcher(line);
            if (spaceMatcher.find(symbolCounter)) {
                line = line.substring(0, spaceMatcher.end()) + " " + line.substring(spaceMatcher.end());
                symbolCounter = spaceMatcher.end() + 1;
                if (!spaceMatcher.find()) {
                    symbolCounter = 0;
                }
            }
        }
        lineArray[position] = line;
    }
}