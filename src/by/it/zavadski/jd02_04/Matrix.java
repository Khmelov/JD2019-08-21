package by.it.zavadski.jd02_04;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    double getValue(int i, int j) {
        return value[i][j];
    }

     Matrix(double[][] value) {
        double[][] neededMatrix=new  double[value.length][value[0].length];
        for (int i = 0; i <neededMatrix.length ; i++)
            System.arraycopy(value[i],0,neededMatrix[i],0,neededMatrix[0].length);
                this.value=neededMatrix;
    }

    public Matrix(Matrix matrix){
        //this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        //this.value = matrix.value;
        double[][] neededMatrix=new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i <matrix.value.length ; i++)
            System.arraycopy(matrix.value[i],0,neededMatrix[i],0,matrix.value[0].length);
        this.value=neededMatrix;
    }

     Matrix(String strMatrix){
         String[] stringNumbers=strMatrix.replaceAll("\\{\\{","").replaceAll("\\}\\}","").replaceAll("\\s","").split("\\}\\,\\{");
         Pattern number=Pattern.compile("[\\d]+\\.?+\\d*");
         double[][] matrixAppended=new double[stringNumbers.length][stringNumbers.length];

         for (int i = 0; i <stringNumbers.length ; i++) {
             int indexCol=0;
             Matcher matcher=number.matcher(stringNumbers[i]);
             while (matcher.find()){
                matrixAppended[i][indexCol]=Double.parseDouble(matcher.group());
                indexCol++;
             }
         }
            this.value=matrixAppended;
        }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("{");
        String delimiter=("");
        for (int i = 0; i <value.length ; i++) {
            stringBuilder.append("{");
            for (int j = 0; j <value[i].length ; j++) {
                stringBuilder.append(delimiter).append(value[i][j]);
                delimiter=", ";

            }
            stringBuilder.append("}");
            if(i+1 < value.length)
                stringBuilder.append(", ");
            delimiter="";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Matrix result=new Matrix(value);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]+=scalarValue;
                }
            }
            return new Matrix(result);
        }else  if(other instanceof Matrix){
            Matrix result=new Matrix(value);
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]+=((Matrix) other).getValue(i,j);
                }
            }
            return new Matrix(result);
        }else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Matrix result=new Matrix(value);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]-=scalarValue;
                }
            }
            return new Matrix(result);
        }else  if(other instanceof Matrix){
            Matrix result=new Matrix(value);
            double[] matrixValue;
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]-=((Matrix) other).getValue(i,j);
                }
            }
            return new Matrix(result);
        }else
            return super.sub(other);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Matrix result=new Matrix(value);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]=result.value[i][j]*scalarValue;
                }
            }
            return new Matrix(result);
        }else  if(other instanceof Vector){
           // Matrix result=new Matrix(value);
            double[] result=new double[this.value.length];
            for (int i = 0; i <this.value.length; i++) {
                for (int j = 0; j <((Vector)other).getValue().length ; j++) {
                    result[i]=result[i]+this.value[i][j]*((Vector) other).getValue()[j];
                }
            }
            return new Vector(result);
        }else  if(other instanceof Matrix){
            //Matrix result=new Matrix(value);
            double[][] result=new double[this.value.length][this.value.length];
            for (int i = 0; i <this.value.length ; i++) {
                for (int j = 0; j <this.value[i].length ; j++) {
                    for (int k = 0; k <((Matrix)other).value.length; k++) {
                        result[i][j]=result[i][j]+this.value[i][k]*((Matrix)other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }else
            return super.mul(other);
    }

}
