package by.it.boytsov.jd01_09;

public class Matrix extends Var
{
    private double[][] value;

    Matrix(double[][] value)
    {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length ; i++)
            System.arraycopy(value[i],0,newMatrix[i],0,value.length);
        this.value=newMatrix;
    }
    Matrix(String strMatrix)
    {
        strMatrix = strMatrix.replaceAll("[{]"," ");
        strMatrix = strMatrix.replaceAll("[}]"," ");
        strMatrix = strMatrix.trim();
        String[] MatrixRows = strMatrix.split(" , ");

        //Ищем кол-во колонок
        String[] row = MatrixRows[0].split(",");
        int columnNum = row.length;

        //Заполнение матрицы элементами
        double[][] newMatrix = new double [MatrixRows.length][columnNum];
        for (int i = 0; i < MatrixRows.length ; i++)
        {
            String[] rowArray = MatrixRows[i].split(",");
            for (int j = 0; j < columnNum; j++)
            {
                newMatrix[i][j]=Double.parseDouble(rowArray[j]);
            }
        }
        this.value = newMatrix;
    }
    Matrix(Matrix Matrix)
    {
        double[][] newMatrix = new double[Matrix.value.length][Matrix.value[0].length];
        for (int i = 0; i < Matrix.value.length; i++)
        {
            System.arraycopy(Matrix.value[i],0,newMatrix[i],0,Matrix.value[0].length);
        }
        this.value=newMatrix;
    }
    @Override
    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder("{{");
        String limiter="";
        for (int i = 0; i < value.length; i++)
        {
            for (int j = 0; j < value[0].length; j++)
            {
                if(j==0)
                    limiter="";
                stringBuilder.append(limiter).append(value[i][j]);
                limiter=", ";
            }
            if (i<=value.length-2)
            {
                stringBuilder.append("}, {");
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    @Override
    public Var add(Var other)
    {
        if (other instanceof Scalar)
        {
            double[][] result=new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[i].length; j++)
                    result[i][j]=this.value[i][j]+((Scalar)other).getValue();
            return new Matrix(result);
        }
        if (other instanceof Matrix)
        {
                double[][] result=new double[this.value.length][this.value.length];
                for (int i = 0; i < this.value.length; i++)
                    for (int j = 0; j < this.value[i].length; j++)
                        result[i][j]=this.value[i][j]+((Matrix)other).value[i][j];
                return new Matrix(result);
        }
        return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sub[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub[i][j]=sub[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        }
        else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] sub=new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, sub[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sub[i][j]=sub[i][j]-((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sub);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] product=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, product[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    product[i][j]=product[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(product);
        }
        else if (other instanceof Vector) {
            if (this.value[0].length==((Vector) other).getValue().length) {
                double[] product=new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        product[i]=product[i]+this.value[i][j]*((Vector) other).getValue()[j];
                    }
                }
                return new Vector(product);
            }
        }
        else if (other instanceof Matrix) {
            if (this.value[0].length==((Matrix) other).value.length) {
                double[][] product=new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < this.value[0].length; k++) {
                            product[i][j]=product[i][j]+this.value[i][k]*((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(product);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[][] div=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, div[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    div[i][j]=div[i][j]/((Scalar) other).getValue();
                }
            }
            return new Matrix(div);
        }
        return super.div(other);
    }
}
