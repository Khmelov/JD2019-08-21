package by.it.rojas.calc;


public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() { return value; }

    public Matrix(double[][] value) { this.value = value;}
    public Matrix(Matrix matrix) { this.value = matrix.value;}
    Matrix(String strMatrix) {
        String str = strMatrix.replaceAll("},","||").replaceAll("\\{\\{","").
                replaceAll("}}","").replaceAll("\\{","");
        String[] obj = str.split("\\|\\|");
        String[][] Arr = new String[obj.length][];
        for (int i = 0; i < obj.length; i++) {
            Arr[i] = obj[i].split(",");
        }
        value = new double[Arr.length][Arr[0].length];
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[0].length; j++)
                value[i][j] = Double.parseDouble(Arr[i][j]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter;
        for (int i = 0; i < value.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append("{");
            delimiter = "";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
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
}
