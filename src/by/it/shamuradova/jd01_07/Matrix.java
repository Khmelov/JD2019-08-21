package by.it.shamuradova.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] mat;

    public Matrix(double[][] mat) {
        this.mat = Arrays.copyOf(mat, mat.length);

        //for (int i = 0; i < mat.length; i++) {
            //for (int j = 0; j < mat[i].length; j++) {
               // this.mat[i][j] = mat[i][j];
           // }
        //}
    }
    public Matrix (Matrix matrix){
        this(matrix.mat);
    }
    public Matrix (String stMatrix){
        stMatrix=stMatrix.replaceAll("\\{", "");
        stMatrix=stMatrix.substring(0, stMatrix.length()-2);
        String [] matrix= stMatrix.split("},");
        double [][] ar = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i]=matrix[i].trim();
            String [] single = matrix[i].split(",");
            for (int j = 0; j < single.length; j++) {
                ar[i][j] = Double.parseDouble(single[j]);
            }
        }
        this.mat=ar;
    }

    public String toString() {
        StringBuilder stB = new StringBuilder("{{");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(j<mat[i].length-1){
                stB.append(mat[i][j] + ", ");
                }
                if (j == mat[i].length - 1 && i < mat.length - 1) {
                    stB.append( mat [i][j] + "},{");
                }
                if (j == mat[i].length - 1 && i == mat.length - 1) {
                    stB.append( mat[i][j] + "}}");
                }
            }
        }
        String s = new String(stB);
        return  s;
    }

}
