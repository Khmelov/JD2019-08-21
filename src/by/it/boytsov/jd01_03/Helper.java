package by.it.boytsov.jd01_03;

import java.util.Scanner;

public class Helper {
    static Scanner scanner = new Scanner(System.in);

    static double findMin(double[] arr) {
        double min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[2];//результат

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        return res;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];//результат
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res[i][j] = res[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        return res;
    }
}


