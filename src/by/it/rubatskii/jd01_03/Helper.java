package by.it.rubatskii.jd01_03;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;

        }
    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;

        }
    }

    static void sort(double[] arr) {

        for (double v : arr) {
            Arrays.sort(arr);
        }

    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] a = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                a[i] = a[i] + matrix[i][j] * vector[j];


        return a;
    }


    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] b = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixLeft.length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    b[i][j] = b[i][j] + matrixLeft[i][k] * matrixRight[k][j];

        return b;

    }


}



