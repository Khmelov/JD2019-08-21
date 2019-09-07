package by.it.gorevoy.jd01_07;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter=", ";
        }
        sb.append("}");
        return  sb.toString();
    }
}

