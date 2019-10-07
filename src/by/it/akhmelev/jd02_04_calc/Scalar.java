package by.it.akhmelev.jd02_04_calc;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other)  throws CalcException {
        if (other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return new Scalar(-1).mul(other.sub(this));
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double value2 = ((Scalar) other).value;
            if (value2==0) {
                throw new CalcException(" division by zero ");
            }
            double result = this.value / value2;
            return new Scalar(result);
        }
        return super.div(other);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String stringValue) {
        value = Double.valueOf(stringValue);
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
