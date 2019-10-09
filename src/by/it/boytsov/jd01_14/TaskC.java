package by.it.boytsov.jd01_14;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        path = path.replace(File.separator + "jd01_14" + File.separator, "");
        String fileTxt = getPath(TaskC.class) + "resultTaskC.txt";
        File root = new File(path);
        try (PrintWriter out2 = new PrintWriter(new FileWriter(fileTxt));) {
            printFile(root, out2);
        } catch (IOException e) {
            System.err.println("Error write " + fileTxt);
        }

    }

    private static void printFile(File fileName, PrintWriter Out){

        if (fileName.isDirectory()) {
            System.out.println("dir:" + fileName.getName());
            Out.print("dir:" + fileName.getName());
            File [] files = fileName.listFiles();
            for( File file: files) {
                if (file.isDirectory())
                    printFile(file.getAbsoluteFile(), Out);
                else {
                    System.out.println("file:" + file.getName());
                    Out.print("file:" + file.getName());
                }
            }
        }
        else {
            System.out.println("file:" + fileName.getName());
            Out.print("file:" + fileName.getName());
        }
    }



    private static String getPath(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskCClass.getName().replace(".", File.separator).replace(taskCClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }

}