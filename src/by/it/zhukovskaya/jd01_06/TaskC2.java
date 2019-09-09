package by.it.zhukovskaya.jd01_06;


import java.util.Random;

public class TaskC2 {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        String s = slow(Poem.text);

        long t2 = System.nanoTime();
        long t3 = System.nanoTime();
        String sb = fast(Poem.text);
        long t4 = System.nanoTime();
        System.out.println(s);
        System.out.println(sb);
        System.out.printf("time = %f%n", (t2 - t1)/1000000.0);
        System.out.printf("time2 = %f", (t4 - t3)/1000000.0);
    }

    private static String slow(String text) {
        String [] arr = text.split("[ \n]");
        String result = "";
        Random rnd = new Random(arr.length-1);
        while (result.length() < 100000) {
            result += arr[rnd.nextInt(arr.length-1)] + " ";
        }
        return result;
    }

    private static String fast(String text) {
        String [] arr = text.split("[ \n]");
        StringBuilder result = new StringBuilder();
        Random rnd = new Random(arr.length-1);
        while (result.length() < 100000) {
            result.append(arr[rnd.nextInt(arr.length-1)] + " ");
        }
        return result.toString();
    }
}
