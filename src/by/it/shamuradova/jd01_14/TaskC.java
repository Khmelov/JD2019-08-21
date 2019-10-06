package by.it.shamuradova.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {

        String path = getPath(TaskC.class);
        //System.out.println(path);

        File folder = new File(path);
        for (File file : folder.listFiles()) { //возвращает массив файлов, массив указателей на все файлы, которые лежат в каталоге
            if(file.isDirectory()) {
                System.out.println("dir:"+ file.getName());
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if(file1.isDirectory()){
                        System.out.println("dir:"+ file1.getName());
                        File[] filess = file1.listFiles();
                        for (File file2 : filess) {
                            String nameFile=file2.getName();
                            System.out.println("file:"+ nameFile);
                        }
                    }
                    else {
                        String nameFile = file1.getName();
                        System.out.println("file:" + nameFile);
                    }
                }
            }
            else{
                System.out.println(file.getName());
            }
        }

        String fileTxt = path + "jd01_14\\"+ "resultTaskC.txt"; //зададим текстовый файл
        printToFile(fileTxt, folder);



    }
    private static void printToFile(String fileTxt, File folder){
        try(PrintWriter out = new PrintWriter(new FileWriter(fileTxt))
        ){
            for (File file : folder.listFiles()) { //возвращает массив файлов, массив указателей на все файлы, которые лежат в каталоге
                if(file.isDirectory()) {
                    out.println("dir:"+ file.getName());
                    File[] files = file.listFiles();
                    for (File file1 : files) {
                        if(file1.isDirectory()){
                            out.println("dir:"+ file1.getName());
                            File[] filess = file1.listFiles();
                            for (File file2 : filess) {
                                String nameFile=file2.getName();
                                out.println("file:"+ nameFile);
                            }
                        }
                        else {
                            String nameFile = file1.getName();
                            out.println("file:" + nameFile);
                        }
                    }
                }
                else{
                    out.println(file.getName());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static String getPath(Class<TaskC> taskCClass) {
        String rootProject = System.getProperty("user.dir"); //C:\Users\Бегенч\IdeaProjects\JD2019-08-21
        String subpath = taskCClass.getName().replace(".", File.separator).replace(taskCClass.getSimpleName(), "");
        subpath = subpath.replace("jd01_14\\", "");
        String path = rootProject + File.separator + "src" + File.separator + subpath;
        return path;             
        
    }
}
