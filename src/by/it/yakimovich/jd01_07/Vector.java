package by.it.yakimovich.jd01_07;

public class Vector extends Var {
    double[] value;

    public Vector(double[] value){
        this.value=new double[value.length];
        for (int i = 0; i <value.length; i++) {
            this.value[i]=value[i];

        }
    }
    public Vector (Vector vector){
        Vector v1= new Vector(vector.value);
        this.value=v1.value;
    }
    public  Vector(String strVector){
        strVector=strVector.replaceAll("[{}]", "");
        String[] arrayString=strVector.split(",");
        this.value=new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            this.value[i]=Double.parseDouble(arrayString[i]);

        }
    }
    public  String toString() {
        StringBuilder stringBild = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                stringBild.append(value[i] + "," + " ");
            }
            if (i == value.length - 1) {
                stringBild.append(value[i] + "}");
            }
        }
        String i = new String(stringBild);
        return i;
            }
}
