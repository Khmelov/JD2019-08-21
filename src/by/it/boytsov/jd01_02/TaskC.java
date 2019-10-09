package by.it.boytsov.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = step1(n);
        step2(matrix);
        step3(matrix);
    }

    public static int[][] step1(int n) {
        boolean max = true;
        boolean min = true;
        int[][] array = new int[n][n];
        do {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -n + (int) (Math.random() * (2 * n + 1));

                    if (array[i][j] == -n) {
                        min = false;
                    }

                    if (array[i][j] == n) {
                        max = false;
                    }
                }
                System.out.print("\n");
            }
        } while (max || min);
        return array;
    }

    public static int step2(int[][] mas) {
        /*Найти, вывести и вернуть сумму элементов исходной матрицы mas,
    расположенных между первым и вторым положительными элементами
    каждой строки. Сигнатура int step2(int[ ][ ] mas).*/
        int sum = 0;
        int count = 0;
        boolean true_false = true;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {

                //System.out.printf("% -2d ", mas[i][j]);
                if (mas[i][j] > 0 && count < 2) {
                    // sum+=mas[i][j];
                    count++;
                }
                if (mas[i][j] <= 0 && count == 1) {
                    sum += mas[i][j];
                }
            }
            count = 0;
            System.out.println();
        }
        System.out.print(sum);
        return sum;
    }

    public static int[][] step3(int[][] mas) {/*
       Найти максимальный элемент(ы) в матрице и удалить из исходной
       матрицы все строки и столбцы, его содержащие. Вывести в консоль и
       вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] mas).*/

        boolean[] delColumn = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];

        //поиск максимального значеня
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max)
                    max = mas[i][j];
            }
        }
        //поиск удаляемых строк и столбцов
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delColumn[j] = true;
                    delRow[i] = true;
                }
            }
        }
        //Размер новой матрицы
        int rowCount = 0;
        for (boolean count : delRow) {
            if (!count)
                rowCount++;
        }
        int columnCount = 0;
        for (boolean count : delColumn) {
            if (!count)
                columnCount++;
        }
        //Матрица после изменений
        int[][] resultMas = new int[rowCount][columnCount];
        int rowMas = 0;
        int colMas = 0;
        for (int i = 0; i < mas.length; i++)
        {
            if (!delRow[i])
            {
                for (int j = 0; j < mas[i].length; j++) {
                    {
                        if (!delColumn[j]) {
                            resultMas[rowMas][colMas++] = mas[i][j];
                        }
                    }
                }
                rowMas++;
                colMas = 0;
            }
        }
        //Вывод матрицы
        for (int i = 0; i <= rowCount-1; i++)
        {
            for (int j = 0; j <= columnCount-1; j++)
            {
                System.out.println(resultMas[i][j]+" ");
                if(j==columnCount-1)
                    System.out.println();
            }
        }
        return resultMas;
    }
}