package by.it.yakimovich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double sum = 0;

        try {
            for (; ; ) {
                String line = sc.next ();
                if (line.equals ("END")) break;
                Double d = Double.valueOf (line);
                sum += d;
                if (sum < 0) throw new ArithmeticException ();
                System.out.println (d + "\n" + Math.sqrt (sum));
            }


        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] trace = e.getStackTrace ();
            for (StackTraceElement element : trace) {
                String className = element.getClassName ();
                if (className.contains ("TaskB")) {
                    String name = e.getClass ().getName ();
                    int lineNumber = element.getLineNumber ();
                    System.out.printf (" name: %s\n" +
                            "class: %s\n" +
                            " line: %d\n",
                            name, className, lineNumber);
                }
            }
        }
    }
}
