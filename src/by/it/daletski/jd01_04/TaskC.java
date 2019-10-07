package by.it.daletski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String line = sc.nextLine ();
        buildOneDimArray (line);

    }

    public static void buildOneDimArray(String line) {

        double[] array = InOut.getArray (line);
        double start = array[0];
        double stop = array[array.length - 1];
        InOut.printArray (array, "V", 5);
        Helper.sort (array);
        InOut.printArray (array, "V", 4);

        int startIndex = Arrays.binarySearch (array, start);
        int stopIndex = Arrays.binarySearch (array, stop);
        System.out.printf ("Index of first element=%1d%n", startIndex);
        System.out.printf ("Index of last element=%1d%n", stopIndex);
    }

    static int binarySearch(double[] array, double value) {
        return 1;
    }


    static int mergeSort(double[] array, int left, int right) {
        double d = array[right];
        int sort = 0;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < d) {
                array[i] = array[sort + 1];
            }
            array[i] = array[sort];
        }
        return sort;
    }

}