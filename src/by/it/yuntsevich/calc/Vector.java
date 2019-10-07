package by.it.yuntsevich.calc;

import java.util.Arrays;

public class Vector extends Var {
     private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    //Vector(Vector vector) {
//        this.value = Arrays.copyOf(vector.value, vector.value.length);
//    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("\\{", "").replaceAll("}", "");
        String[] items = strVector.split(",");
        double[] result = new double[items.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(items[i]);
        }

        this.value = Arrays.copyOf(result, result.length);
    }

    @Override
    public Var add(Var other)  throws CalcException{
        if (other instanceof Scalar) {
          //  System.out.println(this);
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();

            }//System.out.println(this);
                return new Vector(res);
            }

         else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
                return new Vector(res);
            }
         else

            return super.add(other);
    }

    @Override
    public Var sub(Var other)  throws CalcException{

            if (other instanceof Scalar) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] -= ((Scalar) other).getValue();
                }
                return new Vector(res);
            }

            else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] -= ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            else

                return super.sub(other);
        }


    @Override
    public Var mul(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }

        else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] *((Vector) other).value[i];
                sum +=res[i];
            }
            return new Scalar(sum);
        }
        else

            return super.mul(other);
    }

    @Override
    public Var div(Var other)  throws CalcException{
        if (other instanceof Scalar &&  ((Scalar) other).getValue()!=0) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.div(other);


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
