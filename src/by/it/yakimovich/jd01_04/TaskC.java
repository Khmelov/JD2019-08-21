package by.it.yakimovich.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        double[] a = {1, -2, 3, 4, -5, 6, 7, 8, 9, 0};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void mergeSort(double[] array) {
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
        mergeSort(part1);
        mergeSort(part2);
        double[] result = merge(part1, part2);
        return result;
    }

    private static double[] merge(double[] part1, double[] part2) {
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        double[] result = new double[part1.length + part2.length];
        while (i < result.length) {
            if (i2 == part2.length || (i1 < part1.length && part1[i1] < part2[i2])) {
                result[i++] = part1[i1++];

            } else {
                result[i++] = part2[i2++];
            }
        }
        return result;
    }
}
