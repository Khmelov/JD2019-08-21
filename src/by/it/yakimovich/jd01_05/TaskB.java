package by.it.yakimovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <=2; a+=0.2) {
            double y=0;
            for (int x = 1; x <=6; x++) {
                y+=(pow(7,a)- cos(x));
                System.out.printf("%s%.2f%s%f\n" , "a =", a, "sum y", y);
            }
        }
    }

    private static void step2() {
    }
}
