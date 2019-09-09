package by.it.zlotnikova.jd01_07;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        this.value = stringToMatrix(strMatrix);
    }

    private static double[][] stringToMatrix(String str) {

        String[] strArray = str.split("[\\}]+");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].replaceAll("[^0-9\\.]+", " ");
            strArray[i] = strArray[i].trim();
        }

        String[][] strMatrix = new String[strArray.length][strArray.length];
        for (int i = 0; i < strMatrix.length; i++) {
            strMatrix[i] = strArray[i].split(" ");
        }

        double[][] result = new double[strMatrix.length][strMatrix[0].length];
        for (int i = 0; i < strMatrix.length; i++) {
            for (int j = 0; j < strMatrix[i].length; j++) {
                result[i][j] = Double.parseDouble(strMatrix[i][j]);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String opening = "{";
        for (double[] doubles : value) {
            String delimiter = "";
            sb.append(opening);
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(doubles[j]);
                delimiter = ", ";
            }
            sb.append("}");
            opening = ", {";
        }
        sb.append("}");
        return sb.toString();
    }
}
