package by.it.boytsov.jd01_08;

public class Scalar extends Var{

    private double value;

    Scalar(double value)
    {
        this.value=value;
    }
    Scalar(Scalar scalar)
    {
        this.value=scalar.value;
    }
    Scalar(String str)
    {
        this.value=Double.parseDouble(str);
    }
    @Override
    public String toString()
    {
        return Double.toString(value);
    }
    public double getValue()
    {
        return value;
    }
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return new Scalar(-1).mul(other.sub(this));
    }
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }
}

