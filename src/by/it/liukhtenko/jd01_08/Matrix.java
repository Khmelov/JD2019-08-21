package by.it.liukhtenko.jd01_08;

import java.util.Arrays;

public  class Matrix extends Var {

    private double [][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix (double[][]value){
        this.value = value;
    }
    Matrix (Matrix matrix){
        this.value = matrix.value;
    }
    Matrix (String strMatrix){
        String str = strMatrix.replaceAll("},","||").replaceAll("\\{\\{","").
                replaceAll("}}","").replaceAll("\\{","");
        String[] obj = str.split("\\|\\|");
        String[][] Arr = new String[obj.length][];
        for (int i = 0; i < obj.length; i++) {
            Arr[i] = obj[i].split(",");
        }
        value = new double[Arr.length][Arr[0].length];
        for (int i=0; i<Arr.length;i++){
            for (int j =0; j < Arr[0].length;j++)
           value[i][j] = Double.parseDouble(Arr[i][j]);
        }
    }

    @Override
    public Var add(Var other) {
        double [] [] res = new double[value.length][value[0].length];
        if (other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value [0].length; j++) {
                    value [i][j] = value [i][j] + ((Scalar)(other)).getValue();
                }
            }
            return new Matrix(value);
        }
        else if ( other instanceof Vector){
            return super.add(other);
        }
        else
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res [i][j] = this.value [i][j] + ((Matrix)(other)).getValue()[i][j];

                }

            }

        return new Matrix(res);
    }


    @Override
    public Var sub(Var other) { double [] [] res = new double[value.length][value[0].length];
        if (other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value [0].length; j++) {
                    value [i][j] = value [i][j] - ((Scalar)(other)).getValue();
                }
            }
            return new Matrix(value);
        }
        else if ( other instanceof Vector){
            return super.add(other);
        }
        else
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res [i][j] = this.value [i][j] - ((Matrix)(other)).getValue()[i][j];

                }

            }

        return new Matrix(res);
    }



    @Override
    public Var mul(Var other) {
        double [] vec = new double[value.length];
        double [] [] res = new double[value.length][value[0].length];
        if (other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value [0].length; j++) {
                    value [i][j] = value [i][j] * ((Scalar)(other)).getValue();
                }
            }
            return new Matrix(value);
        }
        else if ( other instanceof Vector){
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                   // for (int k = 0; k < 1; k++) {
                        vec [i] += this.value [i][j] * ((Vector)(other)).getValue()[j];
                    }

               //}

            }

            return new Vector(vec);
                }
        else
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        res [i][j] += this.value [i][k] * ((Matrix)(other)).getValue()[k][j];
                    }


                }

            }

        return new Matrix(res);
    }

    @Override
    public Var div(Var other) {
        double[][] res = new double[value.length][value[0].length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    value[i][j] = value[i][j] / ((Scalar) (other)).getValue();
                }
            }
            return new Matrix(value);
        } else {
            return super.add(other);

        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i =0; i< value.length;i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append("{");
            delimiter = "";
            for (int j=0; j< value[0].length;j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}



