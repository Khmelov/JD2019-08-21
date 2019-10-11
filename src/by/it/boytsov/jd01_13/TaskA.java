package by.it.boytsov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("Привет");
        } catch (Exception exception) {
            StackTraceElement[] stackTrace = exception.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String className = element.getClassName();
                if(className.contains("TaskA")){
                    String name = exception.getClass().getName();
                    int number = element.getLineNumber();
                    System.out.printf(" name: %s\n " + " class: %s\n" + " line: %d\n",
                            name, className, number);
                }
            }
        }
    }
}