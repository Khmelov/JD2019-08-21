package by.it.yakimovich.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    double[] value;

    public Vector(double[] value){
        this.value=new double[value.length];
        for (int i = 0; i <value.length; i++) {
            this.value[i]=value[i];

        }
    }
    public Vector (Vector vector){
        Vector v1= new Vector(vector.value);
        this.value=v1.value;
    }
    public  Vector(String strVector){
        strVector=strVector.replaceAll("[{}]", "");
        String[] arrayString=strVector.split(",");
        this.value=new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            this.value[i]=Double.parseDouble(arrayString[i]);

        }
    }
    public  String toString() {
        StringBuilder stringBild = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                stringBild.append(value[i]).append(",").append(" ");
            }
            if (i == value.length - 1) {
                stringBild.append(value[i]).append("}");
            }
        }
        String i = new String(stringBild);
        return i;
            }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] + ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value, value.length );
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] + ((Vector)other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = this.value[i] - ((Scalar) other).getValue();
                return new Vector(res);
        }
        if (other instanceof Vector) {
             double[] res=Arrays.copyOf(value, value.length);
             for (int i = 0; i < this.value.length; i++)
                 res[i]=this.value[i] - ((Vector)other).value[i];
                 return new Vector(res);
         }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] * ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double skalar=0;
            for (int i = 0; i < this.value.length; i++) {
                skalar+=this.value[i] * ((Vector)other).value[i];
            }
            return new Scalar(skalar);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]= this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return null;
    }
}
