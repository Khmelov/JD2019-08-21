package by.it.yuntsevich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "yuntsevich"+ File.separator;
        String filetxt = getPath(TaskC.class) + "resultTaskC.txt";

        File directory = new File(path);
        try (PrintWriter out = new PrintWriter(new FileWriter(filetxt))) {
            tree(directory, out);
        } catch (IOException e) {
            System.err.println("Error write " + filetxt);
        }
    }

    private static void tree(File file, PrintWriter out) {

        File[] files = file.listFiles();
        assert files != null;
        for (File fileRek : files) {
            if (fileRek.isFile()) {
                out.println("file:" + fileRek.getName());
                System.out.println("file:" + fileRek.getName());
            } else if (fileRek.isDirectory()) {
                out.println("dir:" + fileRek.getName());
                System.out.println("dir:" + fileRek.getName());
                tree(fileRek, out);
            }
        }
    }

    private static String getPath (Class < TaskC > taskCClass) {
        String rootProject = System.getProperty("user.dir");

        String subPath = taskCClass.getName().replace(".", File.separator).replace(taskCClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

}
