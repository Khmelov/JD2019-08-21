package by.it.krautsevich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static String getNeededPath(Class<TaskC> someClass) {
        String rootProject = System.getProperty("user.dir");

        String subPaths = someClass.getName().replace(".", File.separator).
                replace(someClass.getSimpleName(), "").replace(File.separator+"jd01_14" , "");

        String path = rootProject + File.separator + "src" + File.separator + subPaths;
        return path;
    }

    private static String getPath(Class<TaskC> someClass) {
        String rootProject = System.getProperty("user.dir") ;
        String subPaths = someClass.getName().replace("." , File.separator).
                replace(someClass.getSimpleName() , "") ;
        String path = rootProject + File.separator + "src" + File.separator + subPaths ;
        return path ; }



    public static void main(String[] args) {

        String pathNeed = getNeededPath(TaskC.class) ;
        File lookForFile = new File (pathNeed) ;
        File[] fileList = lookForFile.listFiles();
        PrintWriter writer = null ;
        String filename = "resultTaskC.txt" ;
        String path = getPath(TaskC.class);
        String resultName = path + "resultTaskC.txt" ;

        try {writer = new PrintWriter(new FileWriter(resultName));
        for (File element : fileList) {
            if (element.isFile()) {
                System.out.println("file:" + element.getName());
                writer.println("file:" + element.getName());
            }
            else if (element.isDirectory()) {
                System.out.println("dir:" + element.getName());
                writer.println("dir:" + element.getName());
                File[] newFileList = element.listFiles();
            for (File new_element1 : newFileList) {
                System.out.println("file:" + new_element1.getName());
                writer.println("file:" + new_element1.getName());
            }
            }
        }}
        catch (IOException e) {
            System.err.println(filename + " не удается сохранить в файл");
        }
        finally {if (writer != null)
            writer.close();}}



    }
