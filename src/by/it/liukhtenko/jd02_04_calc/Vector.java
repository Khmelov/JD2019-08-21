package by.it.liukhtenko.jd02_04_calc;

import java.util.Arrays;

class Vector extends Var {
    private double [] value;

    public double[] getValue() {
        return value;
    }

    Vector (double [] value){
         this.value = value;
     }
     Vector (String StrVector){
         StrVector = StrVector.substring(1,StrVector.length()-1);
         String [] converter = StrVector.split(",");
         value = new double[converter.length];
         for (int i=0; i<converter.length;i++){
             value[i] = Double.parseDouble(converter[i]);
         }

     }

     Vector (Vector vector){
         this.value = vector.value;
     }

    @Override
    public Var add(Var other) throws CalcException {
    if (other instanceof Scalar){
        double [] res = Arrays.copyOf(value,value.length);
        for (int i = 0; i < value.length; i++) {
            res [i] = res[i] + ((Scalar)(other)).getValue();
        }
        return new Vector(res);
    }
    else if ( other instanceof Vector) {
        if(value.length != ((Vector) other).value.length)
            throw new CalcException(" неверная длина");
        double [] res = Arrays.copyOf(value,value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] + ((Vector) other).value[i];
        }
        return new Vector(res);
    }
    else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < value.length; i++) {
                res [i] = res[i] -((Scalar)(other)).getValue();
            }
            return new Vector(res);
        }
        else if ( other instanceof Vector){
            if(value.length != ((Vector) other).value.length)
                throw new CalcException(" неверная длина");
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
         double v=0;
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < value.length; i++) {
                res [i] =  ((Scalar)(other)).getValue() * res[i];
            }
            return new Vector(res);
        }
        else if ( other instanceof Vector){
            if(value.length != ((Vector) other).value.length)
                throw new CalcException(" неверная длина");
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
                v+= res[i];
            }

            return new Scalar(v) ;
        }
        else
            return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < value.length; i++) {
                res [i] =  res [i]/((Scalar)(other)).getValue();
            }
            return new Vector(res);
               }
        else
            return super.add(other);

    }
//@Override
   /* public String toString2() {
        String s = Arrays.toString(value);
        s= s.substring(1,s.length()-1);
        return "{" +
                s+
                '}';
    }*/

   /* @Override
    public String toString(){
        String s = "{";
        String delimetr = "";
        for (double v : value) {
            s += delimetr+ v;
            delimetr = ", ";
        }

         s += "}";
        return s;*/

       // return Arrays.toString(value).replace('[','{').replace(']','}');
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";

        }
        sb.append("}");
        return sb.toString();
    }
}
