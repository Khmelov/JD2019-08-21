package by.it.yakimovich.jd01_15;



import java.io.*;

public class TaskA {
    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }

    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for(int j=0; j < array[i].length; j++)
                array[i][j] = -15 + (int) (Math.random() * 31);
        }
        String path = getPath(TaskA.class);
        String filename = path + "matrix.txt";
        try (PrintWriter outF = new PrintWriter(
                new FileWriter(filename))){
            for (int[] row : array) {
                for (int element: row) {
                    outF.printf("%3d ", element);
                }
                outF.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader inF = new BufferedReader(new FileReader(filename))) {
            while (inF.ready())
                System.out.println(inF.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
