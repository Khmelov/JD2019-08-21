package by.it.gorevoy.jd01_07;

class Scalar extends Var{

    private double value;
    Scalar (double value){
        this.value = value;
    }
    Scalar (String Str){
         this.value = Double.parseDouble(Str);
    }
    Scalar (Scalar scalar){
         this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
