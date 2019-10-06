package by.it.kiturka.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        double parsedLine;
        double sum = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("end"))
                break;
            try {
                parsedLine = Double.parseDouble(line);
                System.out.println(parsedLine);
                sum = sum + parsedLine;
                if (sum < 0 )
                    throw new ArithmeticException();
                System.out.println(Math.sqrt(sum));
            }
            catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d",name,className,lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
