package by.it.yuntsevich.jd01_15;

import java.io.*;

public class TaskA {
    private static String getPath(Class<TaskA> taskAClass) {
    String rootProject = System.getProperty("user.dir");

    String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
    return rootProject + File.separator + "src" + File.separator + subPath;
}
    public static void main(String[] args) {
    int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15+(int)(Math.random()*31);
            }
        }

        for (int[] row:array){
            for (int element:row){
                System.out.printf("%3d ",element);
            }
            System.out.println();
        }

        String filename = getPath(TaskA.class).concat("matrix.txt");

        try(PrintWriter out = new PrintWriter(new FileWriter(filename)))
        {
        for (int[] row:array){
            for (int element:row){
                out.printf("%3d ",element);
            }
            out.println();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader in = new BufferedReader(new FileReader(filename))){
            while(in.ready()){
                System.out.print((char)in.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
