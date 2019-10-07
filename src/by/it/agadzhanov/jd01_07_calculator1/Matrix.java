package by.it.agadzhanov.jd01_07_calculator1;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, newMatrix[i], 0, value[0].length);
        }
        this.value = newMatrix;
    }

    Matrix(Matrix otherMatrix) {
        double[][] newMatrix = new double[otherMatrix.value.length][otherMatrix.value[0].length];
        for (int i = 0; i < otherMatrix.value.length; i++) {
            System.arraycopy(otherMatrix.value[i], 0, newMatrix[i], 0, otherMatrix.value[0].length);
        }
        this.value = newMatrix;
    }

    Matrix(String stringMatrix) {
        stringMatrix = stringMatrix.replaceAll("[{]", " ");
        stringMatrix = stringMatrix.replaceAll("[}]", " ");
        stringMatrix = stringMatrix.trim();
        String[] stringMatrixRows = stringMatrix.split(" , ");

        // Найти число колонок
        String[] exampleRow = stringMatrixRows[0].split(",");
        int columnNumber = exampleRow.length;

        // Заполнить матрицу элементами
        double[][] newDoubleMatrix = new double[stringMatrixRows.length][columnNumber];
        for (int i = 0; i < stringMatrixRows.length; i++) {
            String[] rowArray = stringMatrixRows[i].split(",");
            for (int j = 0; j < columnNumber; j++) {
                newDoubleMatrix[i][j] = Double.parseDouble(rowArray[j]);
            }
        }
        this.value = newDoubleMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ { ");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append(" }, { ");
            }
        }
        sb.append(" } }");
        return sb.toString();
    }
}