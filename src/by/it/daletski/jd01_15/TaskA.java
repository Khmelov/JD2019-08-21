package by.it.daletski.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName()
                .replace(".", File.separator)
                .replace(taskAClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

    public static void main(String[] args) {

        int[][] array = new int[6][4];
        fillArray(array);
        String filename = getPath(TaskA.class).concat("matrix.txt");
        saveMatrix(array, filename);
        readMatrix(filename);


    }

    private static void readMatrix(String filename) {
        try {
            Files
                    .lines(Paths.get(filename))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveMatrix(int[][] array, String filename) {
        try (
                PrintWriter out = new PrintWriter(
                        new FileWriter(filename)
                )
        ) {
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
    }
}

