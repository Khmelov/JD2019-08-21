package by.it.agadzhanov.jd01_011_calculator4;

import java.util.Arrays;

class Vector extends Var {

    public double[] getValue() {
        return value;
    }

    private double[] value;

    Vector(double[] value) {
        double[] newVector = new double[value.length];
        System.arraycopy(value, 0, newVector, 0, value.length);
        this.value = newVector;
    }

    Vector(Vector otherVector) {
        double[] newVector = new double[otherVector.value.length];
        System.arraycopy(otherVector.value, 0, newVector, 0, otherVector.value.length);
        this.value = newVector;
    }

    Vector(String stringVector) {
        stringVector = stringVector.replaceAll("[{]", " ");
        stringVector = stringVector.replaceAll("[}]", " ");
        stringVector = stringVector.replaceAll("[,]", " ");
        stringVector = stringVector.trim();
        String[] strVectorArray = stringVector.split(" ");
        double[] doubleVectorArray = new double[strVectorArray.length];
        for (int i = 0; i < doubleVectorArray.length; i++) {
            doubleVectorArray[i] = Double.parseDouble(strVectorArray[i]);
        }
        this.value = doubleVectorArray;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + ((Scalar) other).getValue();
            }
            return new Vector(sum);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] sum = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sum.length; i++) {
                    sum[i] = sum[i] + ((Vector) other).value[i];
                }
                return new Vector(sum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] sub = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < sub.length; i++) {
                    sub[i] = sub[i] - ((Vector) other).value[i];
                }
                return new Vector(sub);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] product = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < product.length; i++) {
                product[i] = product[i] * ((Scalar) other).getValue();
            }
            return new Vector(product);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double product = 0;
                for (int i = 0; i < this.value.length; i++) {
                    product = product + this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(product);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[] div = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
