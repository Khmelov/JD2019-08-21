package by.it.zlotnikova.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) {
        String fileForReading = getPath(TaskB.class) + "TaskB.java";
        String fileForWriting = getPath(TaskB.class) + "TaskB.txt";
        try {
//            List<String> lines = Files.readAllLines(Paths.get(fileForReading));
//            boolean comment = false;
//            for (int i = 0; i < lines.size(); i++) {
//                String line = lines.get(i);
//                if (line.contains("//")) {
//                    line.substring(0, )
//                }
//
//            }
            StringBuilder sb = new StringBuilder();
            Files.lines(Paths.get(fileForReading)).forEachOrdered(s -> sb.append(s).append("\n"));
            PrintWriter out = new PrintWriter(
                    new FileWriter(fileForWriting));
            out.print(sb);
            out.flush();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* The method creates a matrix of random integer numbers between -15 and 15,
     then saves it to the file "matrix.txt" in the same folder that contains the task itself
     and finally reads the matrix from the file and prints it to console */
    private static void processMatrix() {
        int[][] matrix = createMatrix(6, 4);
        String filename = getPath(TaskB.class) + "matrix.txt";
        printToFile(matrix, filename);
        readFromFile(filename);
    }

    // The method reads a given file and prints it to console
    private static void readFromFile(String filename) {
        try {
            Files.lines(Paths.get(filename)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The method prints a matrix to a text file
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

    /**
     * @param rows    defines the number of rows.
     * @param columns defines the number of columns.
     * @return the matrix of given size.
     * @author e.zlotnikova
     * Creates a matrix of random integer numbers between -15 and 15.
     */
    private static int[][] createMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (-15 + Math.random() * 31);
            }
        }
        return matrix;
    }

    /* The method returns a path (as String) to a package,
     which contain the class defined in an input parameter */
    private static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }
}
