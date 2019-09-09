package by.it.daletski.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        this.value = Arrays.copyOf (value, value.length);
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
    public String toString(){
        StringBuilder sb = new StringBuilder ("{");
        String delimetr = "";
        for (double element : value){
            sb.append (delimetr).append (element);
            delimetr=", ";
        }
        sb.append ("}");
        return sb.toString ();
    }


}
