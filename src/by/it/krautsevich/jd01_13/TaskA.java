package by.it.krautsevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет"); }

        catch (NullPointerException | NumberFormatException e) {
             StackTraceElement [] trace = e.getStackTrace() ;
             for (StackTraceElement element : trace) {
                 String className = element.getClassName() ;
             if (className.contains("I18n")) {
                    String name = e.getClass().getName();
                    int clazzNumber = element.getLineNumber() ;

                    System.out.printf(" name: %s\n"
                            + " class: %s\n"
                            + " line: %d\n", name , className , clazzNumber);}
             }
        }
    }
}
