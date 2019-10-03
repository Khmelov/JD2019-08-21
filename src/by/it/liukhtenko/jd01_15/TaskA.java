package by.it.liukhtenko.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        newarray(array);
        String filename = dir(TaskA.class).concat("matrix.txt");
        savematrix(array,(filename));
        readmatrix(filename);
    }
    private static void newarray(int [][] array ){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array [i][j] = (int) (-15 + (Math.random()*31));
            }
        }
    }
    private static void readmatrix (String filename){
        try {
            Files
                    .lines(Paths.get(filename))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void savematrix (int [][] array,String filename){
        try (
            PrintWriter out = new PrintWriter(
                    new FileWriter(filename))
        ){
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ",element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}