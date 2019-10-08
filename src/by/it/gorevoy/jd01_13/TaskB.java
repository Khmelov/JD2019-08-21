package by.it.gorevoy.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        double sum=0;
        double square = 0;
        try {
            while (!(input=scanner.nextLine()).equals("END")){
                sum+=Double.valueOf(input);
                if(sum<0)
                    throw new ArithmeticException();
                System.out.println(input);
                square= Math.sqrt(sum);
                System.out.println(square);
                }
            } catch (NumberFormatException|ArithmeticException e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String className = element.getClassName();
                        String name = e.getClass().getName();
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name:%s\n class:%s\n line:%d\n",name,className,lineNumber);
                        break;
                    }
                }
            }

    }
}