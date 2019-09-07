package by.it.kiturka.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        System.out.println(min + " ");
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        System.out.println(max + " ");
        return max;
    }


   /* static double sort(double[] arr) {


        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);

    } */

     static void sort(double [] arr) {
         double save;
         for (int i = 0; i < arr.length; i++) {
             for (int j = i + 1; j < arr.length; j++) {
                 if (arr[i] > arr[j]) {
                     save = arr[i];
                     arr[i] = arr[j];
                     arr[j] = save;
                 }

             }


         }


         for (double m : arr) {
             System.out.print(m + " ");
             //System.out.println();
         }
     }


}


