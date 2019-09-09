package by.it.rojas.jd03;

import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {
        Scanner scanner= new Scanner (System.in);
        String str= scanner.nextLine();

        double [] array =   InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double[] min = new double[0];
        Helper.findMin(min);
        double[] max = new double[0];
        Helper.findMax(max);
        double[] arr = new double[0];
        Helper.sort(arr);
    }
}
