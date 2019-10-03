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

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res=new double[matrix.length];
        for (int i = 0; i <= matrix.length-1; i++) {
            for (int j = 0; j <= vector.length-1; j++) {
                res[i]=res[i]+matrix[i][j]*vector[j];
            }
        }
        return res;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] res=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <= matrixLeft.length-1; i++) {
            for (int j = 0; j <= matrixRight[0].length-1; j++) {
                for (int k = 0; k <= matrixRight.length-1; k++) {
                    res[i][j]=res[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return res;
    }

}

