package by.it.zhukovskaya.jd01_14;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        path = path.replace(File.separator+"jd01_14" + File.separator, "");
        String fileTxt = getPath(TaskC.class) + "resultTaskC.txt";
        File root = new File(path);
        try (PrintWriter out2 = new PrintWriter(new FileWriter(fileTxt));) {
            printFile(root, out2);
        } catch (IOException e) {
            System.err.println("Error write " + fileTxt);
        }
    }

    private static void printFile(File fileName, PrintWriter pOut){
        if (fileName.isDirectory()) {
            System.out.println("dir:" + fileName.getName());
            pOut.print("dir:" + fileName.getName());
            File [] files = fileName.listFiles();
            for( File f: files) {
                if (f.isDirectory())
                    printFile(f.getAbsoluteFile(), pOut);
                else {
                    System.out.println("file:" + f.getName());
                    pOut.print("file:" + f.getName());
                }
            }
        }
        else {
            System.out.println("file:" + fileName.getName());
            pOut.print("file:" + fileName.getName());
        }
    }

    private static String getPath(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskCClass.getName().replace(".", File.separator)
                .replace(taskCClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}

