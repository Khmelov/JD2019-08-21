package by.it.shamuradova.jd01_15;

/**
 * JavaDoc
 */

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".java"; //the first comment
        String wrFileName = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".txt"; //the second comment
        System.out.println(filename);
        /*
         multicoment
         */
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             PrintWriter pw = new PrintWriter(new FileWriter(wrFileName))) {
            char c, c1;
            while (br.ready()) {
                c = (char) br.read();
                if (c == '/') {
                    c1 = (char) br.read();
                    if (c1 == '/')
                        while ((c = (char) br.read()) != '\n') ;
                    else if (c1 == '*') {
                        while ((char) br.read() != '*' || (char) br.read() != '/') ;
                        continue;
                    } else {
                        sb.append(c).append(c1);
                        pw.print(c);
                        pw.print(c1);
                        continue;
                    }
                }
                sb.append(c);
                pw.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
    /*
         multicoment
         */

    private static String getPath(Class<?> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskBClass.getName().replace(".", File.separator).replace(taskBClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}
