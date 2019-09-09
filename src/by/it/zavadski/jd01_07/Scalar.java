package by.it.zavadski.jd01_07;

public class Scalar extends Var{
    private double value;
    public Scalar(){

    }
    Scalar(double value){
        this.value=value;
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
