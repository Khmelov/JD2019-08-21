package by.it.akhrem.calc;

import java.util.Arrays;

public class Vector extends Var {

    private double [] value;

    public Vector(double[] value)  {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector) {
        String[] strArray = strVector.replaceAll("\\{", "").replaceAll("}", "").split(",");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            result.append(delimiter).append(v);
            delimiter = ", ";
        }
        result.append("}");
        return result.toString();
    }


    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
               result[i] = this.value[i] + ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double [] result = new double [this.value.length];
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(Var.rm.get("Vector.ErrNotEqualSize"));
            for  (int i = 0; i< this.value.length; i++)
                result[i] = this.value[i] + ((Vector) other).value[i];
            return new Vector(result);
        }
        return this.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] - ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double [] result = new double [this.value.length];
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(Var.rm.get("Vector.ErrNotEqualSize"));
            for  (int i = 0; i< this.value.length; i++)
                result[i] = this.value[i] - ((Vector) other).value[i];
            return new Vector(result);
        }
        return this.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] * ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double scalar = 0;
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException(Var.rm.get("Vector.ErrNotEqualSize"));
            for  (int i = 0; i< this.value.length; i++)
                scalar += this.value[i] * ((Vector) other).value[i];
            return new Scalar(scalar);
        }
        return this.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] / ((Scalar) other).getValue();
            return new Vector(result);
        }
        throw new CalcException(Var.rm.get("Vector.ErrUnavailableOperation"));
    }
}
