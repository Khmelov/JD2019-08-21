package by.it.kiturka.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] mas = step1(n);
        int sum = step2(mas);
        System.out.println(sum);

        mas=step3(mas);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        Random randomNum = new Random();
        boolean posnflag = false;
        boolean negnflag = false;
        do {
            for (int i = 0; i <= n - 1; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    if (i == 0 && j == 0) {
                        posnflag = false;
                        negnflag = false;
                    }
                    mas[i][j] = -n + randomNum.nextInt(2 * n + 1);
                    if (mas[i][j] == n)
                        posnflag = true;
                    if (mas[i][j] == -n)
                        negnflag = true;
                }

            }
        }
        while (!posnflag || !negnflag);

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                System.out.print(mas[i][j] + " ");
                if (j == n - 1)
                    System.out.println();
            }

        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        int poselemcount = 0;
        int[][] requiredelementmas = new int[mas.length][mas.length];
        for (int i = 0; i <= mas.length - 1; i++) {
            for (int j = 0; j <= mas.length - 1; j++) {
                if (j == 0)
                    poselemcount = 0;
                if (poselemcount == 2)
                    requiredelementmas[i][j] = 0;
                if (mas[i][j] > 0 && poselemcount == 1) {
                    poselemcount++;
                }
                if (mas[i][j] <= 0 && poselemcount == 1)
                    requiredelementmas[i][j] = 1;
                if (mas[i][j] > 0 && poselemcount == 0) {
                    poselemcount++;
                }
            }
        }

        for (int i = 0; i <= requiredelementmas.length - 1; i++) {
            for (int j = 0; j <= requiredelementmas.length - 1; j++) {
                if (requiredelementmas[i][j] == 1)
                    sum = sum + mas[i][j];
            }

        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas){
        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];

        //find max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max)
                    max = mas[i][j];
            }
        }
        //mark deleted position
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }

        //calc size
        int rowCount = 0;
        for (boolean value : delRow) {
            if (!value) rowCount++;
        }
        int colCount = 0;
        for (boolean value : delCol) {
            if (!value) colCount++;
        }

        //create result
        int[][] res=new int[rowCount][colCount];

        //fill result
        int ir = 0;
        int jr = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr++] = mas[i][j];
                    }

                }
                ir++;
                jr = 0;
            }
        }

        for (int i = 0; i <= rowCount-1; i++) {
            for (int j = 0; j <= colCount-1; j++) {
                System.out.print(res[i][j]+" ");
                if (j == colCount - 1)
                    System.out.println();
            }

        }
        return res;
    }

}