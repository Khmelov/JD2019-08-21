package by.it.zavadski.jd02_04;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;
    public double[] getValue() {
        return value;
    }
     Vector(double[] value){
        this.value= Arrays.copyOf(value,value.length);
    }

    public Vector(Vector vector){ this.value=vector.value; }


    Vector (String strVector) throws CalcException {
        Pattern pattern = Pattern.compile("[\\d.]+");
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
    public Var add(Var other) throws CalcException {
         if (other instanceof Scalar) {
             double [] res=Arrays.copyOf(this.value,this.value.length);
             double scalarValue=((Scalar) other).getValue();
             for (int i = 0; i <res.length ; i++) {
                 res[i]+=scalarValue;
             }
             return new Vector(res);
             }else  if(other instanceof Vector){
             double[] res=Arrays.copyOf(this.value,this.value.length);
             double[] VectorValue=((Vector)other).value;
             for (int i = 0; i <res.length ; i++) {
                 res[i]+=VectorValue[i];
             }
             return new Vector(res);
         }else
             return super.add(other);
         }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double [] res=Arrays.copyOf(this.value,this.value.length);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <res.length ; i++) {
                res[i]-=scalarValue;
            }
            return new Vector(res);
        }else  if(other instanceof Vector){
            double[] res=Arrays.copyOf(this.value,this.value.length);
            double[] VectorValue=((Vector)other).value;
            for (int i = 0; i <res.length ; i++) {
                res[i]-=VectorValue[i];
            }
            return new Vector(res);
        }else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double [] res=Arrays.copyOf(this.value,this.value.length);
            double scalarValue=((Scalar) other).getValue();
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]*scalarValue;
            }
            return new Vector(res);
        }else  if(other instanceof Vector){
            double[] res=Arrays.copyOf(this.value,this.value.length);
            double[] VectorValue=((Vector)other).value;
            double multiply=0;
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]*VectorValue[i];
                multiply=multiply+res[i];
            }
            return new Scalar(multiply);
        }else
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double scalarValue = ((Scalar) other).getValue();
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / scalarValue;
                if(scalarValue==0)
                    throw new CalcException("Деление на ноль ");
            }
            return new Vector(res);
        }
        return super.div(other);
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
