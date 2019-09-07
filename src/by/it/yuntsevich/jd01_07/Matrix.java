package by.it.yuntsevich.jd01_07;

import java.util.Arrays;

public class Matrix extends Var{
    private double[][] value;

    Matrix (double[][] value){
        this.value = Arrays.copyOf(value,value.length);
    }

    Matrix (Matrix matrix){
        this.value = Arrays.copyOf(matrix.value,matrix.value.length);
    }

    Matrix(String strMatrix){
        char [] a = strMatrix.toCharArray();
        int rows = 0;
        for (char c : a) {
            if (c =='}') rows++;
        }
        strMatrix = strMatrix.replaceAll("\\{","").replaceAll("}","").replaceAll(" ","");
        String [] items = strMatrix.split(",");
        int count = 0;
        double[][] result = new double[rows-1][items.length/(rows-1)];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Double.parseDouble(items[count++]);
            }
        }

        this.value = Arrays.copyOf(result, result.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ("{");

        for (int i = 0; i < value.length; i++) {
            double[] row = value[i];
            String delimiter = "";
            sb.append("{");
            for (double a : row) {
                sb.append(delimiter).append(a);
                delimiter = ", ";
            }
            if (i!=value.length-1) sb.append("}, ");
            else sb.append("}");
        }
        sb.append('}');
        return sb.toString();
    }
    }

