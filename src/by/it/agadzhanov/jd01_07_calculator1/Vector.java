package by.it.agadzhanov.jd01_07_calculator1;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        double[] newVector = new double[value.length];
        System.arraycopy(value, 0, newVector, 0, value.length);
        this.value = newVector;
    }

    Vector(Vector otherVector) {
        double[] newVector = new double[otherVector.value.length];
        System.arraycopy(otherVector.value,0,newVector,0,otherVector.value.length);
        this.value = newVector;
    }

    Vector(String stringVector) {
        stringVector = stringVector.replaceAll("[{]", " ");
        stringVector = stringVector.replaceAll("[}]", " ");
        stringVector = stringVector.replaceAll("[,]", " ");
        stringVector = stringVector.trim();
        String[] strVectorArray = stringVector.split(" ");
        double[] doubleVectorArray = new double[strVectorArray.length];
        for (int i = 0; i < doubleVectorArray.length; i++) {
            doubleVectorArray[i] = Double.parseDouble(strVectorArray[i]);
        }
        this.value = doubleVectorArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
