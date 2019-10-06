package by.it.rojas.jd14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    private static String dir2(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").
                replace(".", File.separator);
        return path + clDir;

    }
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").
                replace(".", File.separator).replace(cl.getCanonicalName(), "").
                replace(cl.getCanonicalName(), "");

        return path;
    }
    public static void main(String[] args) {
        File folder = new File(dir(TaskA.class) + "by\\it\\rojas\\");
        File[] listOfFiles = folder.listFiles();

        try (PrintWriter out2 = new PrintWriter(new FileWriter(dir2(TaskC.class) + "resultTaskC.txt"))) {
            assert listOfFiles != null;
            for (File listOfFile : listOfFiles) {
                File folder1 = new File(dir(TaskA.class) + "by\\it\\rojas\\" + listOfFile.getName());
                File[] listOfFiles1 = folder1.listFiles();
                assert listOfFiles1 != null;
                for (File file : listOfFiles1) {
                    if (file.isFile()) {
                        System.out.println("file:" + file.getName());
                        out2.print("file:" + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("dir:" + file.getName());
                        out2.print("dir:" + file.getName());
                    }
                }
                if (listOfFile.isFile()) {
                    System.out.println("file:" + listOfFile.getName());
                    out2.print("file:" + listOfFile.getName());
                } else if (listOfFile.isDirectory()) {
                    System.out.println("dir:" + listOfFile.getName());
                    out2.print("dir:" + listOfFile.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
