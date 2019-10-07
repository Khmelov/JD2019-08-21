package by.it.akhmelev.jd02_04_calc;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String value) {
        //stub
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double part2 = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] += part2;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double[] part2 = ((Vector) other).value;
            for (int i = 0; i < res.length; i++) {
                res[i] += part2[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
