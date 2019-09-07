package by.it.liukhtenko.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int i = 0, columcount = 5, count = 0;
        double[] mas = new double[25];
        for (double x = 5.33; x <= 9; x += 0.1468) {
            mas[i] = cbrt(x * x + 4.5);
            if (mas[i] > 3.5) {
                count++;
            }

            System.out.printf("%s[%-2d]=%2.8f", "A", i, mas[i]);
            i++;

            if (i % columcount == 0) {
                System.out.println();
            }
        }

        System.out.println();
        double[] mas2 = new double[count];
        int j = 0;
        for (int i1 = 0; i1 < mas.length; i1++) {
            if (mas[i1] > 3.5) {
                mas2[j] = mas[i1];
                System.out.printf("%s[%-2d]=%2.8f", "B", j, mas2[j]);
                j++;
                if (j % columcount == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        double geometric = 1;
        for (double element : mas2) {
             geometric *= element;
            System.out.print(geometric);
        }
    }
}

