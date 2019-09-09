package by.it.rubatskii.jd01_07;

public class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String stringValue){
        value=Double.valueOf(stringValue);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
