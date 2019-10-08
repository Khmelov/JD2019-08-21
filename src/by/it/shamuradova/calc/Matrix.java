package by.it.shamuradova.calc;


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

    Matrix() {
    }

    public Matrix(Matrix matrix) {
        this(matrix.mat);
    }

    public Matrix(String stMatrix) {
        stMatrix = stMatrix.replaceAll("\\{", "");
        stMatrix = stMatrix.substring(0, stMatrix.length() - 2);
        String[] matrix = stMatrix.split("},");
        double[][] ar = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = matrix[i].trim();
            String[] single = matrix[i].split(",");
            for (int j = 0; j < single.length; j++) {
                ar[i][j] = Double.parseDouble(single[j]);
            }
        }
        this.mat = ar;
    }

    public String toString() {
        StringBuilder stB = new StringBuilder("{{");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j < mat[i].length - 1) {
                    stB.append(mat[i][j] + ", ");
                }
                if (j == mat[i].length - 1 && i < mat.length - 1) {
                    stB.append(mat[i][j] + "}, {");
                }
                if (j == mat[i].length - 1 && i == mat.length - 1) {
                    stB.append(mat[i][j] + "}}");
                }
            }
        }
        String s = new String(stB);
        return s;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = Arrays.copyOf(this.mat, this.mat.length);
            double[][] sumMatrixScalar = new double[this.mat.length][this.mat.length];
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sumMatrixScalar[i][j] = matrix[i][j] + scalar;
                }
            }
            return new Matrix(sumMatrixScalar);
        } else if (other instanceof Matrix) {
            double[][] matrix1 = Arrays.copyOf(this.mat, this.mat.length);
            double[][] matrix2 = Arrays.copyOf(((Matrix) other).mat, ((Matrix) other).mat.length);
            double[][] sumMatrix = new double[matrix1.length][matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    sumMatrix[i][j] = sumMatrix[i][j] + matrix1[i][j] + matrix2[i][j];
                }
            }
            return new Matrix(sumMatrix);
        } else {
//            String SUCCESS_KEY = "message.success"; //название ключа
//            System.out.println(resourceBundle.get(SUCCESS_KEY)); //по кдючу достаем значения
            return super.add(other);
        }

    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = Arrays.copyOf(this.mat, this.mat.length);
            double[][] matrixResult = new double[matrix.length][matrix.length];
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrixResult[i][j] = matrix[i][j] - scalar;
                }
            }
            return new Matrix(matrixResult);
        } else if (other instanceof Matrix) {
            double[][] matrix1 = Arrays.copyOf(this.mat, this.mat.length);
            double[][] matrix2 = Arrays.copyOf(((Matrix) other).mat, ((Matrix) other).mat.length);
            double[][] subMatrix = new double[matrix1.length][matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    subMatrix[i][j] = subMatrix[i][j] + matrix1[i][j] - matrix2[i][j];
                }
            }
            return new Matrix(subMatrix);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = Arrays.copyOf(this.mat, this.mat.length);
            double[][] mulMatrixScalar = new double[this.mat.length][this.mat.length];
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    mulMatrixScalar[i][j] = matrix[i][j] * scalar;
                }
            }
            return new Matrix(mulMatrixScalar);
        } else if (other instanceof Matrix) {
            double[][] matrix1 = Arrays.copyOf(this.mat, this.mat.length);
            double[][] matrix2 = Arrays.copyOf(((Matrix) other).mat, ((Matrix) other).mat.length);
            double[][] mulMatrixResult = new double[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix2.length; k++) {
                        mulMatrixResult[i][j] = mulMatrixResult[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return new Matrix(mulMatrixResult);
        } else if (other instanceof Vector) {
            double[][] matrix = Arrays.copyOf(this.mat, this.mat.length);
            double[] vector = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double[] mulMatrixVector = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    mulMatrixVector[i] = mulMatrixVector[i] + matrix[i][j] * vector[j];
                }
            }
            return new Vector(mulMatrixVector);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = Arrays.copyOf(this.mat, this.mat.length);
            double[][] divMatrixScalar = new double[this.mat.length][this.mat.length];
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    divMatrixScalar[i][j] = matrix[i][j] / scalar;
                }
            }
            return new Matrix(divMatrixScalar);
        } else {
            return super.div(other);
        }
    }

    //public static void main(String[] args) {
    // String matrix = "{1,2} + {{2,5},{3,1}}";
    //String operation = "+";
    //String[] a = matrix.split("\\+");

    //Var first = determineType(a[0]);
    //Var second = determineType(a[1]);

    //switch (operation) {
    //case "+":
    //first.add(second);
    // break;
    //case "-":
    //first.sub(second);
    // break;
    //case "*":
    //first.mul(second);
    // break;
    //case "/":
    // first.div(second);
    // break;
    // }
    // }

    //private static Var determineType(String a) {
    // Pattern matrixPattern = Pattern.compile("^[{{]{2}");
    // Matcher matrixMatcher = matrixPattern.matcher(a);
    //if (matrixMatcher.find()) {
    //    return new Matrix(a);
    // }
    //Pattern vectorPattern = Pattern.compile("\\{");
    //Matcher vectorMatcher = vectorPattern.matcher(a);

    //if (vectorMatcher.find()) {
    // return new Vector(a);
    // }
    // return new Scalar(a);
    //}
}



