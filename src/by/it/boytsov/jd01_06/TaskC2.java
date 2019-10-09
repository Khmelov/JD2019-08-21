package by.it.boytsov.jd01_06;


import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text;
        long slowTimeStart = System.nanoTime();
        String slowString = slow(text);
       // long slowTimeEnd = System.nanoTime();

        System.out.println(slowString);
        System.out.println("Slow time = " + (System.nanoTime() - slowTimeStart));

        long fastTimeStart = System.nanoTime();
        String fastString = fast(text);
        long fastTimeEnd = System.nanoTime();

        System.out.println(fastString);
        System.out.println("fastTime = " + (System.nanoTime() - fastTimeStart));
    }

    private static String slow(String text) {
        String[] words = text.split("[ \n]");
        String randomLine = "";
        Random random = new Random(words.length - 1);
        while (randomLine.length() <= 100_000) {
            randomLine += words[random.nextInt(words.length - 1)] + " ";
        }
        return randomLine;
    }
    private static String fast(String text)
    {
        String[] words=text.split("[ \n]");
        StringBuilder randomLine=new StringBuilder();
        Random random = new Random(words.length-1);
        while (randomLine.length()<=100000)
        {
            randomLine.append(words[random.nextInt(words.length-1)] + " ");
        }
        return randomLine.toString();
    }
}