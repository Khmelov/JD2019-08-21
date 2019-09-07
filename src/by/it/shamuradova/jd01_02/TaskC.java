package by.it.shamuradova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] m = step1(sc.nextInt());
        System.out.println("Vtoroy method");
        step2(m);

    }
//Задать значения элементов матрицы в интервале значений от -n до n с
//помощью генератора случайных чисел. Числа целые. Тип int.
//Пока в матрице нет чисел n и -n генерацию следует повторять, иначе
//вывести матрицу в консоль, а затем, вернуть полученную матрицу.
//Сигнатура int[ ][ ] step1(int n).
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

//Найти, вывести и вернуть сумму элементов исходной матрицы mas,
//расположенных между первым и вторым положительными элементами
//каждой строки. Сигнатура int step2(int[ ][ ] mas).
    private static int[][] step2(int[][] mas) {
       int n = mas.length;

        int summ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] > 0) {
                    for (int a = j + 1; a < n; a++){
                        if(mas[i][a]>0){
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

//    private static int [][] step3(int[][]m){
//        //находим максимальное число
//        int max=Integer.MIN_VALUE;
//        for (int[] row : m) {
//            for(int e : row){
//                if(e>max){
//                    max=e;
//                }
//            }
//        }
//        boolean[] delCol = new boolean[m[0].length];
//        boolean [] delRow = new boolean[m.length];
//
//        for (int i = 0; i < m.length; i++) {
//            for(int j=0; j<m[i].length; j++){
//
//
//            }
//        }
//        int rowCount=0;
//        int colCount=0;
//        for(boolean b:delCol){
//            if (!b){
//                colCount++;
//            }
//        }
//        for(boolean b: delRow){
//            if(!b){
//                rowCount++ ;
//            }
//        }
//        return m;
//
//    }
}



