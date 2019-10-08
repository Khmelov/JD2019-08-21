package by.it.daletski.jd02_04;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf (value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf (vector.value, vector.value.length);
    }

    public Vector(String strVector) {
        String[] strArray = strVector.replaceAll ("\\{", "").replaceAll ("}", "").split (",");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble (strArray[i]);
        }
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf (this.value, this.value.length);
            double part2 = ((Scalar) other).getValue ();
            for (int i = 0; i < res.length; i++) {
                res[i] += part2;
            }
            return new Vector (res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf (this.value, this.value.length);
            double[] part2 = ((Vector) other).value;
            for (int i = 0; i < res.length; i++) {
                res[i] += part2[i];
            }
            return new Vector (res);
        } else
            return super.add (other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf (value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue ();
            }
            return new Vector (res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf (value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector (res);
        } else
            return super.sub (other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf (value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue ();
            }
            return new Vector (res);
        } else if (other instanceof Vector) {
            double scalar = 0;
            for (int i = 0; i < this.value.length; i++) {
                scalar += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar (scalar);
        } else
            return super.mul (other);

    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++)
                res[i] = this.value[i] / ((Scalar) other).getValue ();
            return new Vector (res);


        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ("{");
        String delimetr = "";
        for (double element : value) {
            sb.append (delimetr).append (element);
            delimetr = ", ";
        }
        sb.append ("}");
        return sb.toString ();
    }


}
