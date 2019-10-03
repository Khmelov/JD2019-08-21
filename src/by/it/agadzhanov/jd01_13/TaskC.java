package by.it.agadzhanov.jd01_13;

import java.util.*;

public class TaskC {

    private static Scanner scanner;
    private static int exceptionCount;
    private static List<Double> numberList;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        exceptionCount = 0;
        numberList = new ArrayList<>();
        for (; ; ) {
            readData();
        }
    }

    private static void readData() throws Exception {
        try {
            numberList.add(scanner.nextDouble());
        } catch (Exception e) {
            Thread.sleep(100);
            exceptionCount++;
            if (exceptionCount > 5)
                throw e;
            scanner.nextLine();
            for (int i = numberList.size() - 1; i >= 0; i--) {
                System.out.print(numberList.get(i) + " ");
            }
            System.out.println("Исключение №" + exceptionCount);
        }
    }
}
