package by.it.rojas.jd05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {

        for (double a = 0; a <= 2; a = a + 0.2) {

            double y = 0;
            for (int x = 1; x <= 6; x++) {

                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%.2f Сумма y = %.4f \n", a, y);
        }
        System.out.println();
    }

    private static void step2() {
        double x;
        double ß;
        double a;

        for (x = -5.5; x < 2; x = x + 0.5) {
            if (-2 < x/2 && x/2 <= -1){
                ß = sin(pow(x,2));
                a = log10(abs(ß+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,ß,a);
            }
            else if (-1 < x/2 && x/2 <= 0.2){
                ß = cos(pow(x,2));
                a = log10(abs(ß+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,ß,a);
            }
            else if (x/2 == 0.2){
                ß = 1.0/tan(pow(x,2));
                a = log10(abs(ß+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,ß,a);
            }
            else {
                System.out.printf("При x/2=%-3.3f %s\n",x/2,"вычисления не определены");
            }
        }
    }
}
