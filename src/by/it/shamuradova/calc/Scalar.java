package by.it.shamuradova.calc;


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
    Scalar(){};

    public double getValue() {
        return value;
    }



    @Override
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add (Var other) throws CalcException{ //сложение Scalar на Scalar
        if (other instanceof Scalar){
            double summaScalar = this.value + ((Scalar) other).value;
            return new Scalar(summaScalar);
        }
        //если other не Scalar, значит матрица или вектор, значит их метод вызываем, п.т. а+в тоже самое, что в+а
        else {
            return other.add(this);
        }
    }
    @Override
    public Var sub (Var other)throws CalcException{
        if (other instanceof Scalar){
            double vichitanieScalar = this.value - ((Scalar) other).value;
            return new Scalar(vichitanieScalar);
        }
        else {
            // 4-3=1; 3-4=-1; чтобы поменять местами, нужно умножить на -1
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul (Var other)throws CalcException{
        if (other instanceof Scalar){
            double umnogenieScalar = this.value * ((Scalar) other).value;
            return new Scalar(umnogenieScalar);
        }
        else {
            return other.mul(this);
        }
    }

    @Override
    public Var div (Var other)throws CalcException{
        if (other instanceof Scalar){
            double delenieScalar = this.value / ((Scalar) other).value;
            return new Scalar(delenieScalar);
        }
        else {
            // деление на матрицу и вектор невозможно - вызываем метод super, где операция невозможна
            return super.div(other);
        }
    }
}



