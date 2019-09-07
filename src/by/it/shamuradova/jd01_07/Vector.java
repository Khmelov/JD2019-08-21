package by.it.shamuradova.jd01_07;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i];
        }
        //this.value= Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        Vector v1 = new Vector(vector.value);
        this.value = v1.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "").trim();
        String[] arrayString = strVector.split(",");
        this.value = new double[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            this.value[i] = Double.parseDouble(arrayString[i]);
        }
    }


    public String toString() {
        StringBuilder stB = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                stB.append(value[i] + "," + " ");
            }
            if (i == value.length - 1) {
                stB.append(value[i] + "}");
            }
        }
        String s = new String(stB);
        return s;

    }
}
