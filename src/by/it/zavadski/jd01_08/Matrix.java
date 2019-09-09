package by.it.zavadski.jd01_08;


public class Matrix extends Var {
    private double[][] value;

    public double getValue(int i, int j) {
        return value[i][j];
    }

    Matrix(double[][] value) {
        double[][] neededMatrix=new  double[value.length][value[0].length];
        for (int i = 0; i <value.length ; i++)
            for (int j = 0; j <value[0].length ; j++)
                neededMatrix[i][j]=value[i][j];
                this.value=neededMatrix;
    }

    public Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("{");
        int i = 0;
        while (i <value.length) {
            stringBuilder.append("{");
            int j = 0;
            while (j <value[i].length) {
                stringBuilder.append(value[i][j]);
                if (j != value[i].length - 1)
                    stringBuilder.append(", ");
                else stringBuilder.append("}");
                j++;
            }
            if (i != value.length-1)
                stringBuilder.append(", ");
            i++;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public Var add(Var other) {
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
            double[] matrixValue;
            for (int i = 0; i <result.value.length; i++) {
                for (int j = 0; j <result.value.length ; j++) {
                    result.value[i][j]+=((Matrix) other).getValue(i,j);
                }
            }
            return new Matrix(result);
        }else
            return super.sub(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
