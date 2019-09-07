package by.it.kiturka.jd01_03;

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


    static void sort(double[] arr) {


        boolean swap;
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


    }
}

