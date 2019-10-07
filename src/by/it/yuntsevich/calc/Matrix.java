package by.it.yuntsevich.calc;

import java.util.Arrays;

public class Matrix extends Var {
     private double[][] value;

     private Matrix(double[][] value){
        this.value = Arrays.copyOf(value,value.length);
    }

//    Matrix (Matrix matrix){
//        this.value = Arrays.copyOf(matrix.value,matrix.value.length);
//    }

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
    public Var add(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[][] res = new double [this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = this.value[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
            else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }

                return new Matrix(res);
            }
        }
         return super.add(other);

    }

    @Override
    public Var sub(Var other)  throws CalcException{

        if (other instanceof Scalar) {
            double[][] res = new double [this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = this.value[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
         return super.add(other);
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double [this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = this.value[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        else if (other instanceof Vector) {
            if (this.value[0].length == ((Vector) other).getValue().length) {
                double[] res = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        res[i] = res[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        }
        else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[i].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j] = res[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(res);

            }
        }
        return super.mul(other);
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

