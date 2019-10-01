package by.it.zavadski.jd01_15;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {
    private static int[][] matrix=new int[6][4];

    public static void main(String[] args) {
        Random random=new Random();
        String ioFile= getClassPath(TaskA.class).concat("matrix.txt");
        printer(ioFile,fulfillMatrix(generateInputRange(-15),random));
        readFile(ioFile);
    }
    public static String getClassPath(Class <?> className){
        String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String classDirectory=className.getName().replace(className.getSimpleName(),"").replace(".",File.separator);
        return path+classDirectory;
    }
    private static int[] generateInputRange(int bound){
        int[] numbers=new int[(bound*(-2)+1)];
        //int bound=-15;
        //Create array with needed numbers for matrix
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i]=bound;
            bound++;
        }
        return numbers;
    }
    private static int[][] fulfillMatrix(int[] inputRange, Random random){
       //Fulfill matrix with numbers from -15 to 15
            for (int i = 0; i <matrix.length; i++) {
                for (int j = 0; j <matrix[i].length; j++) {
                    matrix[i][j]=inputRange[random.nextInt(inputRange.length)];
                }
            }
            return matrix;
        }

    private static void printer(String filename,int[][] matrix) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readFile(String filename){
        try {
            Files.lines(Paths.get(filename)).forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader fileReader=new BufferedReader(new FileReader(filename))){
            while (fileReader.ready()){
                System.out.println(fileReader.readLine());
            }
        }
        catch (IOException e){
            e.printStackTrace();
            }
        }
}
