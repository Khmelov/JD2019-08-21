package by.it.liukhtenko.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main (String[] args){
        double y = 0;
        for (double a = 0; a<=2; a = a+0.2){
            for (double x = 1; x<=6; x++){
                y += pow(7,a) - cos(x);

            }
            System.out.printf("При а =%5.3f y =%g\n",a,y);
        }
        System.out.println();
        step5();
    }

    private static void step5() {
        double x = 0,B=0,a=0;
        for (x =-5.5;x<2;x=x+0.5){
            if (-2<x/2 && x/2<=-1){
                B = sin(x*x);
                a = log10(abs(B+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,B,a);
            }
           else if (-1<x/2 && x/2 <=0.2){
                B = cos(x*x);
                a = log10(abs(B+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,B,a);
            }
           else if (x/2 == 0.2){
                B = 1.0/tan(x*x);
                a = log10(abs(B+2.74));
                System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,B,a);
            }
           else {
                System.out.printf("При x/2=%-3.3f %s\n",x/2,"вычисления не определены");
            }
           // a = log10(abs(B+2.74));
        }
       // System.out.printf("При x/2=%-3.3f B=%g a=%g\n",x/2,B,a);
    }

}
