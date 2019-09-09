package by.it.kiturka.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] m = step1(sc.nextInt());
        System.out.println("Vtoroy method");
        step2(m);


    }

    private static int[][] step1(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        while (true) {

            boolean isPositiveNPresent = false;
            boolean isNegativeNPresent = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int randomInt = rand.nextInt(n * 2 + 1) - n;
                    matrix[i][j] = randomInt;
                    if (randomInt == n) {
                        isPositiveNPresent = true;
                    }
                    if (randomInt == -n) {
                        isNegativeNPresent = true;
                    }
                }
            }
            if (isPositiveNPresent && isNegativeNPresent) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }


    private static int[][] step2(int[][] mas) {
        int n = mas.length;

        int summ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] > 0) {
                    for (int a = j + 1; a < n; a++) {
                        if (mas[i][a] > 0) {
                            break;
                        }
                    }
                    summ += mas[i][j];
                    System.out.println(summ);
                }
                // mas[][1]
            }
        }
        return mas;

    }
}