package by.it.boytsov.jd01_04;

import java.util.Scanner;

public class InOut
{
    static Scanner scanner=new Scanner(System.in);
    static double[] getArray(String line)
    {
        String[] Array=line.split(" ");
        double [] double_array =new double[Array.length];
        for (int i=0;i<Array.length;i++)
        {
            double_array[i]=Double.parseDouble(Array[i]);
        }
        return double_array;
    }
    static void printArray(double[] array)
    {
        for (double element:array)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[] array,String name,int columnCount)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.printf("%s[% -3d]=%4.3f ",name,i,array[i]);
            if((i+1)%columnCount==0 || i+1==array.length)
                System.out.println();
        }
    }
    static double[] getVector()
    {
        double[] vector = new double[3];
        for (int i=0;i<vector.length;i++)
            vector[i]=scanner.nextDouble();
        return vector;
    }
    static double[][]getMatrix()
    {
        double[][] matrix = new double[3][3];
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++)
                matrix[i][j]=scanner.nextDouble();
        return matrix;
    }
    static void printMatrix(double[][] array)
    {
        for (int i=0;i<2;i++)
        {  for (int j=0;j<3;j++)
        {
            System.out.print(array[i][j]+" ");
        }
            System.out.println();
        }
    }
}

