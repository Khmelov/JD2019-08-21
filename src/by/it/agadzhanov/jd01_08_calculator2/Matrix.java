package by.it.agadzhanov.jd01_08_calculator2;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, newMatrix[i], 0, value[0].length);
        }
        this.value = newMatrix;
    }

    Matrix(Matrix otherMatrix) {
        double[][] newMatrix = new double[otherMatrix.value.length][otherMatrix.value[0].length];
        for (int i = 0; i < otherMatrix.value.length; i++) {
            System.arraycopy(otherMatrix.value[i], 0, newMatrix[i], 0, otherMatrix.value[0].length);
        }
        this.value = newMatrix;
    }

    Matrix(String stringMatrix) {
        stringMatrix = stringMatrix.replaceAll("[{]", " ");
        stringMatrix = stringMatrix.replaceAll("[}]", " ");
        stringMatrix = stringMatrix.trim();
        String[] stringMatrixRows = stringMatrix.split(" , ");

        // Найти число колонок
        String[] exampleRow = stringMatrixRows[0].split(",");
        int columnNumber = exampleRow.length;

        // Заполнить матрицу элементами
        double[][] newDoubleMatrix = new double[stringMatrixRows.length][columnNumber];
        for (int i = 0; i < stringMatrixRows.length; i++) {
            String[] rowArray = stringMatrixRows[i].split(",");
            for (int j = 0; j < columnNumber; j++) {
                newDoubleMatrix[i][j] = Double.parseDouble(rowArray[j]);
            }
        }
        this.value = newDoubleMatrix;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] sum=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sum[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sum[i][j]=sum[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);
        }
        else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] sum=new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, sum[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sum[i][j]=sum[i][j]+((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.add(other);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append("}, {");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}