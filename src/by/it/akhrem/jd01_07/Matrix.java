package by.it.akhrem.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double [][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i=0; i < value.length; i++)
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i=0; i < matrix.value.length; i++)
            this.value[i] = Arrays.copyOf(matrix.value[i], matrix.value[i].length);
    }

    Matrix(String strMatrix) {
         String s  = strMatrix.replaceAll("\\{", "");
         s = s.substring(0, s.length()-2);
         String s1[] = s.split("},");
         String my_matrix[][] = new String[s1.length][];
         for (int i = 0; i < s1.length; i++) {
             s1[i] = s1[i].trim();
             String single_double[] = s1[i].split(",");
             my_matrix[i] = new String[single_double.length];
             for (int j = 0; j < single_double.length; j++) {
                 my_matrix[i][j] = single_double[j];
             }
         }
         value = new double [s1.length][];
         for (int i = 0; i<my_matrix.length; i++) {
             value[i] = new double[my_matrix[i].length];
             for (int j = 0; j < my_matrix[i].length; j++) {
                 value[i][j] = Double.parseDouble(my_matrix[i][j]);
             }
         }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for (int i=0; i<value.length; i++) {
            result.append("{");
            String delimiter = "";
            for (double x: value[i]) {
                result.append(delimiter).append(x);
                delimiter = ", ";
            }
            if (i == value.length - 1)
                delimiter = "";
            result.append("}").append(delimiter);
        }
        result.append("}");
        return result.toString();
    }
}
