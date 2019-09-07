package by.it.shamuradova.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stroca = sc.nextLine();
        double[] array = InOut.getArray(stroca);
        InOut.printArray(array);
        InOut.printArray(array, "massiv", 3);
        Helper.findMax(array);
        Helper.findMin(array);
        Helper.sort(array);
        System.out.println();

        double[][] matrix = {{1,2,3}, {2,3,4}};

        double[] vector = {1, 2, 3};


        System.out.println();
        double[] result1 = Helper.mul(matrix, vector);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        double [] [] matrix2= {{2, 0}, {5, 7}, {1,1}};

        System.out.println();

        double[][] result2 = Helper.mul(matrix, matrix2);
        for (int i=0; i<result2.length; i++){
            for(int j=0; j<result2[i].length; j++){
                System.out.print(result2[i][j] + " ");
            }
        }


    }
}
