package by.it.daletski.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String line = sc.nextLine ();
        buildOneDimArray (line);

    }

    private static void buildOneDimArray(String line) {
        double[] array = TaskA.getArray(line);
        TaskA.printArray(array, "V", 6);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        TaskA.printArray(array, "V", 6);
        int i;
        i = binarySearch(array, first);
        System.out.printf("Index of first element=%d%n", i);
        i = binarySearch(array, last);
        System.out.printf("Index of last element=%d%n", i);
    }

    private static void mergeSort(double[] array) {
        double ar[] = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = ar[i];
        }
    }

    private static double[] mergeSort(double[] arr, int left, int right) {
        int m;
        if (left < right) {
            m = (left + right) / 2;
            return merge(mergeSort(arr, left, m), mergeSort(arr, m + 1, right));
        } else {
            double a1[] = {arr[left]};
            return a1;
        }
    }

    private static double[] merge(double[] part1, double[] part2) {
        int size = part1.length + part2.length;
        if (size == 0)
            return new double[size];
        else if (part1.length == 0)
            return part2;
        else if (part2.length == 0)
            return part1;
        double[] arr = new double[size];
        int k = 0, i1 = 0, i2 = 0;
        while (i1 < part1.length || i2 < part2.length) {
            if (i1 >= part1.length) {
                while (i2 < part2.length)
                    arr[k++] = part2[i2++];
                continue;
            }
            if (i2 >= part2.length) {
                while (i1 < part1.length)
                    arr[k++] = part1[i1++];
                continue;
            }
            if (part1[i1] < part2[i2]) {
                arr[k] = part1[i1++];
            } else if (part1[i1] == part2[i2]) {
                arr[k++] = part1[i1++];
                arr[k] = part2[i2++];
            } else {
                arr[k] = part2[i2++];
            }
            k++;
        }
        return arr;
    }

    private static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        int m;
        while (left <= right) {
            m = (left + right) / 2;
            if (array[m] == value)
                return m;
            else if (array[m] > value)
                right = m - 1;
            else left = m + 1;
        }
        return -1;
    }
}