package by.it.yuntsevich.jd01_06;

import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String text = Poem.text;
        String s = slow(text);

        System.out.println(s);
        System.out.println(System.nanoTime()-startTime);

        long startTime2 = System.nanoTime();
        String s2 = fast(text);
        System.out.println(s2);
        System.out.println(System.nanoTime()-startTime2);
        }

    static String slow(String text) {
        String [] array = text.split("[ \n]");
        String longRandomLine = "";
        Random random = new Random(array.length-1);
        while (longRandomLine.length()<=100000){
            longRandomLine += array[random.nextInt(array.length-1)] + " ";
        }
        return longRandomLine;
    }

    private static String fast(String text) {
        String [] array = text.split("[ \n]");
        StringBuilder longRandomLine = new StringBuilder();
        Random random = new Random(array.length-1);
        while (longRandomLine.length()<=100000){
            longRandomLine.append(array[random.nextInt(array.length-1)] + " ");
        }
        return longRandomLine.toString();
    }
    }


