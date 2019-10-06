package by.it.zavadski.jd02_04;


public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(){

    }
    Scalar(double value){
        this.value=value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double result=this.value+((Scalar)other).value;
            return new Scalar( result);
        }
        return other.add(this);
    }
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double result=this.value-((Scalar)other).value;
            return new Scalar((result));
        }
        return other.add(this);
    }
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if(((Scalar) other).value==0)
                throw new CalcException("Деление на ноль");
            double result=this.value/((Scalar)other).value;
            return new Scalar((result));
        }
        return other.add(this);
    }
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double result=this.value*((Scalar)other).value;
            return new Scalar((result));
        }
        return other.add(this);
    }

    Scalar(Scalar otherScalar){
    this.value=otherScalar.value;
    }

    Scalar(String strScalar){
        value=Double.parseDouble(strScalar);
    }
    public String toString() {
        return Double.toString(value);
    }

}
