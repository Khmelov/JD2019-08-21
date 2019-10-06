package by.it.rojas.jd13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc = null;
    private static List<Double> list = new ArrayList<>();
    private static int count = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        for (; ; ) {
            readData();
        }
    }

    private static void readData() {
        String Strvalue = sc.next();
        try {
            Double value = Double.valueOf(Strvalue);
            list.add(value);
        } catch (NumberFormatException e) {
            try {
                Thread.sleep(100);
                count++;
                if (count > 5) {
                    throw e;
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i)+" ");
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
