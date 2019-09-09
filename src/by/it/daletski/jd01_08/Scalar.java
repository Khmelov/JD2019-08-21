package by.it.daletski.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar (String str){
        this.value = Double.parseDouble (str);
    }

    Scalar(Scalar scalar){
        this.value=scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString (value);
    }

    interface Operation {
        Var add(Var other);
        Var sub(Var other);
        Var mul(Var other);
        Var div(Var other);
    }
}
