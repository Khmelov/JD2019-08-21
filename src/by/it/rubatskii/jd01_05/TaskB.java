package by.it.rubatskii.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {

                y = ((pow(7, a) - cos(x))) + y;

                System.out.printf("%s%.2f%s%f\n", "При a = ", a, " Сумма y = ", y);
            }


        }
    }

    private static void step2() {

        for (double x = -5.5; x < 2; x += 0.5) {
            double z = x / 2.0;


            if (z > -2 && z <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));

                System.out.printf("При x/2=%-2.2f a = %f %n", z, a);
            } else if (z > -1 && z <= 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));

                System.out.printf("При x/2=%-2.2f a = %f %n", z, a);
            } else if (z == 0.2) {
                double b = 1 / (tan(x * x));
                double a = log10(abs(b + 2.74));

                System.out.printf("При x/2=%-2.2f a = %f %n", z, a);
            } else
                System.out.printf("При x/2=%-2.2f вычисления не определены %n", z);


        }
    }
}


