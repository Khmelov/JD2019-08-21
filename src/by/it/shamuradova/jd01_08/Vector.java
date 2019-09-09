package by.it.shamuradova.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i];
        }
        //this.value= Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        Vector v1 = new Vector(vector.value);
        this.value = v1.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "").trim();
        String[] arrayString = strVector.split(",");
        this.value = new double[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            this.value[i] = Double.parseDouble(arrayString[i]);
        }
    }


    public String toString() {
        StringBuilder stB = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                stB.append(value[i] + "," + " ");
            }
            if (i == value.length - 1) {
                stB.append(value[i] + "}");
            }
        }
        String s = new String(stB);
        return s;

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sumVectorScalar = Arrays.copyOf(this.value, this.value.length);
            double valueScalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) { // или sumVectorScalar.length
                sumVectorScalar[i] = value[i] + valueScalar;
            }
            return new Vector(sumVectorScalar);
        } else if (other instanceof Vector) {
            double[] sumVectorVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < value.length; i++) { // или sumVectorVector.length
                sumVectorVector[i] = value[i] + ((Vector) other).value[i];
            }
            return new Vector(sumVectorVector);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] subVectorScalar = Arrays.copyOf(this.value, this.value.length);
            double valueScalar = ((Scalar) other).getValue();
            for (int i = 0; i < subVectorScalar.length; i++) {
                subVectorScalar[i] = subVectorScalar[i] - valueScalar;
            }
            return new Vector(subVectorScalar);
        } else if (other instanceof Vector) {
            double[] subVector1 = Arrays.copyOf(this.value, this.value.length);
            double[] subVector2 = Arrays.copyOf(((Vector) other).value, ((Vector) other).value.length);

            for (int i = 0; i < subVector1.length; i++) {
                subVector1[i] = subVector1[i] - subVector2[i];
            }
            return new Vector(subVector1);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double [] vektor = Arrays.copyOf(this.value, this.value.length);
            double scalar=((Scalar) other).getValue();
            double [] vektorResult= new double[vektor.length];
            for (int i = 0; i < vektor.length; i++) {
                vektorResult[i]= vektor[i]*scalar;
            }
            return new Vector (vektorResult);
        } else if (other instanceof Vector) {
            double[] mulVector1 = Arrays.copyOf(this.value, this.value.length);
            double[] mulVector2 = Arrays.copyOf(((Vector) other).value, ((Vector) other).value.length);
            double scolarnoeProizvedenieVectorov = 0;
            for (int i = 0; i < mulVector1.length; i++) {
                scolarnoeProizvedenieVectorov = scolarnoeProizvedenieVectorov + mulVector1[i] * mulVector2[i];
            }
            return new Scalar(scolarnoeProizvedenieVectorov);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] divVector1 = Arrays.copyOf(this.value, this.value.length);
            double divScalar = ((Scalar) other).getValue();
            double[] divVectorResult = new double[this.value.length];
            for (int i = 0; i < divVector1.length; i++) {
                divVectorResult[i] = divVector1[i] / divScalar;
            }
            return new Vector(divVectorResult);
        } else {
            return super.div(other);
        }
    }
}
