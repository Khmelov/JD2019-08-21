package by.it.daletski.jd01_05;

import by.it.daletski.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double first = arr[0];
        double last = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        System.out.println();
        mergeSort(arr);
        InOut.printArray(arr, "V", 4);
        System.out.println();
        int indFirst = binarySearch(arr, first);
        int indLast = binarySearch(arr, last);
        System.out.println("Index of first element=" + indFirst);
        System.out.println("Index of last element=" + indLast);
    }

    private static void mergeSort(double[] array) {
        double[] result = mergeSort(array, 0, array.length - 1);
        System.arraycopy(result, 0, array, 0, array.length);
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        if (right <= left)
            return array;
        int mid = (left + right) / 2;
        double[] part1 = new double[mid - left + 1];
        System.arraycopy(array, left, part1, 0, part1.length);
        double[] part2 = new double[right - mid];
        System.arraycopy(array, mid + 1, part2, 0, part2.length);
        return merge(mergeSort(part1, 0, part1.length - 1),
                mergeSort(part2, 0, part2.length - 1));
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] result = new double[part1.length + part2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i < result.length) {
            if (i2 == part2.length || (i1 < part1.length && part1[i1] < part2[i2])) {
                result[i++] = part1[i1++];
            } else {
                result[i++] = part2[i2++];
            }
        }
        return result;
    }

    private static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length -1;
        int valueIndex = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (value == array[m]) {
                valueIndex = m;
                return valueIndex;
            } else {
                if (value < array[m]) {
                    r = m - 1;
                } else {
                    if (value > array[m]) {
                        l = m + 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return valueIndex;
    }
}