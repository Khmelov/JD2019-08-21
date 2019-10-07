package by.it.daletski.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        taskB1 ();
        taskB2 ();
    }

    private static void taskB1() {


        for (double a = 0; a < 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow (7, a) - cos (x);
            }
            System.out.printf ("%7s%.2f%7s%.10f\n", "При a=", a, " Сумма =", y);

        }
    }

    private static void taskB2() {
        double d = 0.5;
        double beta, alfa;
        for (double x = -6 + d; x < 2; x += d) {
            if (-2 < x / 2 && x / 2 < -1)
                beta = sin (x * x);
            else if (-1 < x / 2 && x / 2 < 0.2)
                beta = cos (x * x);
            else if (x / 2 == 0.2)
                beta = 1 / tan (x * x);
            else {
                System.out.printf ("x= %f, alfa= %s%n", x, "корней нет");
                continue;
            }
            alfa = log10 (abs (beta + 2.74));
            System.out.printf ("x= %f, alfa= %f%n", x, alfa);
        }
    }


}



