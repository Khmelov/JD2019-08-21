package by.it.yakimovich.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".java";
        String wrFilename = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".txt";
        System.out.println(filename);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(filename));
             PrintWriter outF = new PrintWriter(new FileWriter(wrFilename))) {
            char ch, ch1;
            while (bf.ready()) {
                ch = (char)bf.read();
                if (ch == '/') {
                    ch1 = (char)bf.read();
                    if (ch1 == '/')
                        while ((ch = (char)bf.read()) != '\n');
                    else if (ch1 == '*') {
                        while ((char) bf.read() != '*' || (char) bf.read() != '/') ;
                        continue;
                    }
                    else {
                        sb.append(ch).append(ch1);
                        outF.print(ch);
                        outF.print(ch1);
                        continue;
                    }
                }
                sb.append(ch);
                outF.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}
