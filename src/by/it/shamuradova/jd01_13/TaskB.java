package by.it.shamuradova.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        for (; ; ) {
            String value = sc.nextLine();
            if (value.equals("END")) {
                break;
            }

            try {
                Double aDouble = Double.valueOf(value);
                list.add(aDouble);
                double sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum = sum + list.get(i);
                }

                if (sum < 0) {
                    throw new ArithmeticException();
                }

                double sqrt = Math.sqrt(sum);
                System.out.println(sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                // e.printStackTrace();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.contains("TaskB")) {
                        String name = e.getClass().getName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n", name, className, lineNumber);
                    }
                }
            }
        }
    }
}