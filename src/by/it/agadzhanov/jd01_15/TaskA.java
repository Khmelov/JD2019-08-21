package by.it.agadzhanov.jd01_15;

import java.io.*;

public class TaskA {

    static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        writeMatrixToFile(matrix);
        readMatrixToFile();
    }

    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
    }

    private static void writeMatrixToFile(int[][] matrix) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "matrix.txt"))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.printf("%3d ", matrix[i][j]);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMatrixToFile() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(dir(TaskA.class) + "matrix.txt"))) {
            while (reader.ready()) {
                String row = reader.readLine();
                System.out.println(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
