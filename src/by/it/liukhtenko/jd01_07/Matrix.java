package by.it.liukhtenko.jd01_07;

public  class Matrix extends Var {

    private double [][] value;
    Matrix (double[][]value){
        this.value = value;
    }
    Matrix (Matrix matrix){
        this.value = matrix.value;
    }
    Matrix (String strMatrix){
        String str = strMatrix.replaceAll("},\\{","||").replaceAll("\\{\\{","").
                replaceAll("}}","");
        String[] obj = str.split("\\|\\|");
        String[][] Arr = new String[obj.length][];
        for (int i = 0; i < obj.length; i++) {
            Arr[i] = obj[i].split(",");
        }
        value = new double[Arr.length][Arr[0].length];
        for (int i=0; i<Arr.length;i++){
            for (int j =0; j < Arr[0].length;j++)
           value[i][j] = Double.parseDouble(Arr[i][j]);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i =0; i< value.length;i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("{");
            delimiter = "";
            for (int j=0; j< value[0].length;j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}



