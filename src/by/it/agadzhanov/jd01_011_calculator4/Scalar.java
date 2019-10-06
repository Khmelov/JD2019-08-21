package by.it.agadzhanov.jd01_011_calculator4;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(this); //если other был вектором или матрицей, то add ищем в соответствующем классе
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else {
            Scalar minus = new Scalar(-1);
            return other.mul(minus).add(this); //5-{1,2,3} --> -1*{1,2,3}+5
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double product = this.value * ((Scalar) other).value;
            return new Scalar(product);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).value != 0) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
