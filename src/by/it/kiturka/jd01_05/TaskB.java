package by.it.kiturka.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class TaskB {
    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
          for( int x = 1; x<=6; x++){
              y += pow(7,a) - cos(x);

          }
            System.out.println(a+ y);

        }
    }

    private static void step2() {

        for (double x = -5.5; x < 2; x = x + 0.5) {
            double b = 0;
            double a;

            double halfX = x / 2;
            if (-2 < halfX && halfX <= -1) {
                b = sin(x * x);
            } else if (-1 < halfX && halfX < 0.2) {
                b = cos(x * x);
            } else if (halfX == 0.2) {
                b = 1 / tan(x * x);
            }

            if (b == 0) {
                System.out.printf("При x/2=%.2f вычисления не определены", x/2);
                System.out.println();
            } else {
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f a=%.6e", x/2, a);
                System.out.println();
            }
        }

    }

}

