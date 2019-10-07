package by.it.yuntsevich.jd01_15;

import java.io.*;

/**
 * @author Svetlana
 */

public class TaskB {
    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");

        String subPath = taskBClass.getName().replace(".", File.separator).replace(taskBClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

    // считываем содержимое файла в String с помощью BufferedReader
    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {

            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        //System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    private static String deleteComments(String path) {
        char[] ch0 = path.toCharArray();

        boolean multipleComments = false;
        boolean singleComments = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch0.length; i++) {
            if (ch0[i] == '/' && ch0[i + 1] == '/') {
                singleComments = true;
                continue;
            } else if (ch0[i] == '\n') {
                singleComments = false;
            } else if (ch0[i] == '/' && ch0[i + 1] == '*') {
                multipleComments = true;
                continue;
            } else if (ch0[i] == '/' && ch0[i + 1] == '*' && ch0[i + 2] == '*') {
                multipleComments = true;
                continue;
            } else if (ch0[i] == '/' && ch0[i - 1] == '*') {
                multipleComments = false;
                continue;
            }
/*
multipleComment
 */
            if (!multipleComments && !singleComments) {
                sb.append(ch0[i]);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
/*        String path = getPath(TaskB.class);
       System.out.println(getPath(TaskB.class));*/
        String filename = getPath(TaskB.class) + ("TaskB.java");
        try {
            System.out.println(deleteComments(readUsingBufferedReader(filename)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileOut = getPath(TaskB.class).concat("TaskB.txt");

        try(PrintWriter out = new PrintWriter(new FileWriter(fileOut)))
        {
            out.print(deleteComments(readUsingBufferedReader(filename)));
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    }

