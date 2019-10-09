package by.it.boytsov.jd01_03;

import java.util.Scanner;

public class Runner
{
   static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
       //Scanner scanner=new Scanner(System.in);

        //double str3=scanner.nextLine();
        double[][]matrix=InOut.getMatrix();
        double[] vector=InOut.getVector();
        InOut.printMatrix(matrix);InOut.printArray(vector);
        Helper.mul(matrix, vector);
        double[][]matrixLeft=InOut.getMatrix();
        double[][]matrixRight=InOut.getMatrix();
        Helper.mul(matrixLeft,matrixRight);
    }
}
