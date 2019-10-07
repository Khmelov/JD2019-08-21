package by.it.shamuradova.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    public static void main(String[] args) {

        //в метод можно
        String rootProject = System.getProperty("user.dir"); //        C:\Users\Бегенч\IdeaProjects\JD2019-08-21
        Class<TaskA> taskAClass = TaskA.class;
        String subpath = taskAClass.getName(); //        by.it.shamuradova.jd01_15.TaskA
        subpath = subpath.replace(".", File.separator).replace(taskAClass.getSimpleName(), ""); //    by\it\shamuradova\jd01_15\
        String path = rootProject + File.separator + "src" + File.separator + subpath;// C:\Users\Бегенч\IdeaProjects\JD2019-08-21\src\by\it\shamuradova\jd01_15\
        System.out.println(path);

        //задали имя файла
        String fileName = path + "matrix.txt";

        //заполняем матрицу случайными числами
        //тоже в метод
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
        //вывод матрицы в файл
        try( PrintWriter printWriter= new PrintWriter(new FileWriter(fileName))){
            for (int[] arrays : matrix) {
                for (int element : arrays) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        //читаем файл и выводим в консоль
        try {
            Files.lines(Paths.get(fileName)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
