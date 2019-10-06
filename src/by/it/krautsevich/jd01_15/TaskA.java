package by.it.krautsevich.jd01_15;

import java.io.*;

public class TaskA {
    private static String getPath(Class<?> getClass) {
        String rootProject = System.getProperty("user.dir") ;
        String subPaths = getClass.getName().replace("." , File.separator).
                replace(getClass.getSimpleName() , "") ;
        String path = rootProject + File.separator+ "src" + File.separator + subPaths ;
        return path ;
    }

    public static void main(String[] args) {

        int [][] array = new int [6][4] ;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {

                array[i][j] = (int) (Math.random()*31)-15 ;
            }
        }
        String filename = getPath(TaskA.class) + "matrix.txt" ;

        try (PrintWriter printer = new PrintWriter(new FileWriter(filename)))
            {for (int [] row : array)
            { for (int  element : row)
            {printer.printf("%3d " , element);}
                printer.println();
            }}
        catch (IOException e)
            {
                System.out.println( "Не могу записать файл " + filename);
            }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {while (reader.ready())
            System.out.print((char) reader.read());}
        catch (IOException e)
        {
            System.out.println( "Не могу прочитать файл " + filename);
        }
    }
}
