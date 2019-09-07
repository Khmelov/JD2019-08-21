package by.it.yuntsevich.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
       // this.value = new double[value.length];
        //for (int i = 0; i < value.length; i++) {
          //  this.value[i] = value[i];
        //}
        this.value = Arrays.copyOf(value,value.length);
    }

    Vector(Vector vector){
        this.value = Arrays.copyOf(vector.value,vector.value.length);
    }

    Vector(String strVector){
        strVector = strVector.replaceAll("\\{","").replaceAll("}","");
        String [] items = strVector.split(",");
        double[] result = new double[items.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(items[i]);
        }

        this.value = Arrays.copyOf(result, result.length);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ("{");
        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
