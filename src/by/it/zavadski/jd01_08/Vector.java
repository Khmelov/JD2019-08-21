package by.it.zavadski.jd01_08;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;
     Vector(double[] value){
        this.value= Arrays.copyOf(value,value.length);
    }

    public Vector(Vector vector){ this.value=vector.value; }


    @Override
    public Var add(Var other){
         if (other instanceof Scalar) {
             double [] res=Arrays.copyOf(this.value,this.value.length);
             double scalarValue=((Scalar) other).getValue();
             for (int i = 0; i <res.length ; i++) {
                 res[i]+=scalarValue;
             }
             return new Vector(res);
             }else  if(other instanceof Vector){
             double[] res=Arrays.copyOf(this.value,this.value.length);
             double[] scalarValue=((Vector)other).value;
             for (int i = 0; i <res.length ; i++) {
                 res[i]+=scalarValue[i];
             }
             return new Vector(res);
         }else
             return super.add(other);
         }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double [] res=Arrays.copyOf(this.value,this.value.length);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <res.length ; i++) {
                res[i]-=scalarValue;
            }
            return new Vector(res);
        }else  if(other instanceof Vector){
            double[] res=Arrays.copyOf(this.value,this.value.length);
            double[] scalarValue=((Vector)other).value;
            for (int i = 0; i <res.length ; i++) {
                res[i]-=scalarValue[i];
            }
            return new Vector(res);
        }else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double [] res=Arrays.copyOf(this.value,this.value.length);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]*scalarValue;
            }
            return new Vector(res);
        }else  if(other instanceof Vector){
            double[] res=Arrays.copyOf(this.value,this.value.length);
            double[] scalarValue=((Vector)other).value;
            double multiply=0;
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]*scalarValue[i];
                multiply=multiply+res[i];
            }
            return new Scalar(multiply);
        }else
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalarValue = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / scalarValue;
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    Vector (String strVector){
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher=pattern.matcher(strVector);
        String[] arrayDigits=new String[strVector.length()];
        int index=0;
        while (matcher.find()){
            arrayDigits[index]=matcher.group();
            index++;
        }
        double[] arrayDouble=new double[index];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i]=Double.parseDouble(arrayDigits[i]);
        }
        this.value=arrayDouble;

    }
    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("{");
        String delimiter="";
        for (double v : value) {
            stringBuilder.append(delimiter).append(v);
            delimiter=", ";
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}
