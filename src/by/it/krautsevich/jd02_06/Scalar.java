package by.it.krautsevich.jd02_06;

public class Scalar extends Var {

    private double value ;
    public Scalar() {}

    public Scalar(double value) {
        this.value = value;}

    public double getValue() {
        return value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value ;}

    public Scalar (String stringValue) {
        this.value = Double.valueOf(stringValue) ;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {double result = this.value + ((Scalar) other).value ;
            return new Scalar(result);}
        return other.add(this) ;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {double result = this.value - ((Scalar) other).value ;
            return new Scalar(result);}
        return new Scalar(-1).mul(other.sub(this)) ;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {double result = this.value * ((Scalar) other).value ;
            return new Scalar(result);}
        return other.mul(this) ;
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) {throw new CalcException("Деление на ноль");}
            else {double result = this.value / ((Scalar) other).value ;
        return new Scalar(result);}}
        return super.div(other) ;
    }



    @Override
    public String toString() {
        return String.valueOf(value);}

}
