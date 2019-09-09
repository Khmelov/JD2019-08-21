package by.it.zhukovskaya.jd01_07;

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
}
