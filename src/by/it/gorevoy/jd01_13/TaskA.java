package by.it.gorevoy.jd01_13;

import java.util.HashMap;

public class TaskA{
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException|NullPointerException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String className = element.getClassName();
                    String name = e.getClass().getName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf(" name:%s\n class:%s\n line:%d\n",name,className,lineNumber);
                    break;
                }
                //System.out.println(stackTraceElement);
            }
        }
    }
}
