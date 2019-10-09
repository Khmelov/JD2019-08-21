package by.it.boytsov.jd01_13;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TaskC {
    private static Scanner scanner;
    private static List<Double> list = new ArrayList<>();
    private static int errorCounter = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main (String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        for (; ; ) {
            readData();
        }
    }

    private static void readData() throws InterruptedException {

        String strValue = scanner.next();
        try {
            Double value = Double.valueOf(strValue);
            list.add(value);
        } catch (NumberFormatException exception) {
            Thread.sleep(100);
            errorCounter++;
            if (errorCounter > 5)
                throw exception;
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}