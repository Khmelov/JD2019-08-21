package by.it.kiturka.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
       step1();
       step2();
       step3();
    }

    private static void step1() {
double a = 756.13;
double x = 0.3;
double s1 = cos(pow((x*x+PI/6),5));
double s2 = sqrt(x*pow(a,3));
double s3 = log(abs((a-1.12*x)/4));
double result = s1-s2-s3;
        System.out.println(result);
    }

    private static void step2() {
double a = 1.21;
double b = 0.371;
double s1 = tan(pow((a+b),2));
double s2 = cbrt(a+1.5);
double s3 = a*pow(b,5);
double s4 = b/log(a*a);
double result = s1-s2+s3-s4;
        System.out.println(result);
    }

    private static void step3() {
double x = 12.1;
        for (double a = -5; a <=12 ; a = a+3.75) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("При a=%6.2f f=%g\n  ", a,f);


        }

    }


}
