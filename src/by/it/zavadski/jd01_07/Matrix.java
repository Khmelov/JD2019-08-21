package by.it.zavadski.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
       this.value=value;
    }

    public Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("{");
        int i = 0;
        while (i <value.length) {
            stringBuilder.append("{");
            int j = 0;
            while (j <value[i].length) {
                stringBuilder.append(value[i][j]);
                if (j != value[i].length - 1)
                    stringBuilder.append(", ");
                else stringBuilder.append("}");
                j++;
            }
            if (i != value.length-1)
                stringBuilder.append(", ");
            i++;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
