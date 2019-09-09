package by.it.zhukovskaya.jd01_07;

public class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    public Scalar(String stringValue) {
        value = Double.valueOf(stringValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
