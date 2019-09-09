package by.it.kiturka.jd01_05;

import java.lang.reflect.Array;

import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {

        double x = 5.33;
        double[] arr1 = new double[30];
        double z;
        double y = (9 - 5.33) / 29;

        for (int i = 0; i < arr1.length; i++) {
            if (5.33 <= x && x <= 9) {
                z = pow((x * x + 4.5), 1.0 / 3);
                arr1[i] = z;
                x += y;
            }
        }
        System.out.println("Массив arr1");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1 [%d] = %.5f ", i, arr1[i]);
            if (i % 5 == 0) {
                System.out.println();
            }
        }
        createNewArray2(arr1);
    }

    private static void createNewArray2(double[] arr1) {


    }

}