package by.it.zlotnikova.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {

    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4);
        String filename = getPath(TaskA.class) + "matrix.txt";
        printToFile(matrix, filename);
        readFromFile(filename);
    }

    private static void readFromFile(String filename) {
        try {
            Files.lines(Paths.get(filename)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(int[][] matrix, String filename) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(filename))
        ) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    out.printf("%3d ", matrix[i][j]);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] createMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (-15 + Math.random() * 31);
            }
        }
        return matrix;
    }

    private static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }
}
