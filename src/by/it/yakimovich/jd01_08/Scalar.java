package by.it.yakimovich.jd01_08;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double add1=this.value+((Scalar) other).value;
            return new Scalar(add1);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub1=this.value-((Scalar) other).value;
            return new Scalar(sub1);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul1=this.value+((Scalar) other).value;
            return new Scalar(mul1);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div1=this.value/((Scalar) other).value;
            return new Scalar(div1);
        }
        else
            return super.div(other);
    }

    Scalar (String str) {
        this.value=Double.parseDouble(str);
    }

    Scalar (Scalar scalar) {
        this.value=scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value) ;
    }
}
