package by.it.rojas.jd04;

import java.util.Arrays;

class Helper {

    static double findMin (double[] arr){
            double min=arr[0];

            for (double element : arr) {

                if (min > element) min = element;

            }
            System.out.println(min+ " ");
        return min;
    }

   static double findMax(double[ ] array){
            double max=array[10];

            for (double element : array) {

                if (max < element) max = element;

            }
            System.out.println(" " + max);

       return max;
   }

    public static void sort(double[ ] arr){

        boolean swap;
        int last=arr.length-1;
        do {
            swap = false;
            for (int j = 0; j < last ; j++){
                if (arr[j]>arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;

                }
            }
            last--;
        }
        while (swap);

        System.out.print(Arrays.toString(arr) + " ");
        System.out.println();
    }
}


