package by.it.shamuradova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if(className.contains("TaskA")){
                    String name = e.getClass().getName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\n"+ "class: %s\n" + "line: %d\n", name, className, lineNumber);
                }

            }
            //int length = stackTrace.length;
            //String className = stackTrace[length - 1].getClassName();
            //System.out.println(className);
            //int lineNumber = stackTrace[length - 1].getLineNumber();
            //System.out.println(lineNumber);
            //String name = stackTrace[length - 1].getClass().getName();
            //System.out.println(name);
            //String name1 = stackTrace[length - 1].getClassName().getClass().getName();
            //System.out.println(name1);
            //System.out.printf("name: %s\n"+ "class: %s\n" + "line: %d\n", name, className, lineNumber);




        }
    }
}
