package by.it.krautsevich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    static private Scanner sc ;
    static private ArrayList<Double> list = new ArrayList<>(10) ;
    static private int countOfErrors ;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        for ( ; ; )
        {readData() ; }
    }

    private static void readData() {

        try {
            String str = sc.next() ;
            Double value = Double.valueOf(str) ;
            list.add(0 , value) ;
        }

        catch (NumberFormatException e) {
            try {
                Thread.sleep(100);
                countOfErrors++ ;
                if (5 <= countOfErrors) {throw e ; }
                for (Double element : list ) {
                    System.out.print(element + " ");
                }
                System.out.println();


            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
