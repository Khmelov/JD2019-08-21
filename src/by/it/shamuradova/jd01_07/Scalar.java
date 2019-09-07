package by.it.shamuradova.jd01_07;

public class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);

    }

    Scalar(Scalar sc) {
        this.value = sc.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}



