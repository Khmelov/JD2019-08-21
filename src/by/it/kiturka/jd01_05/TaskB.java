package by.it.kiturka.jd01_05;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

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

        for (double x = -6; x < 2; x = x + 0.5) {
            double b = 0;
            double a = 0;

           /* double α = log(abs(2.74 + β));
            for (double x = -2; x/2 <=-1 ; ) {
                double β = sin(pow(x,2));
                for (double x = -1;  x/2<0.2) {
                    double β = cos(pow(x,2));
                    for (double x = -1;  x/2=0.2) {
                        double β = 1/tan((pow(x,2)); */


                }

            }


            }


