package by.it.boytsov.jd01_07;

public class Matrix extends Var
{
    private double[][] value;

    Matrix(double[][] value)
    {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length ; i++)
        {
            System.arraycopy(value[i],0,newMatrix[i],0,value.length);
        }
        this.value=newMatrix;
    }
    Matrix(String strMatrix)
    {
        strMatrix = strMatrix.replaceAll("[{]"," ");
        strMatrix = strMatrix.replaceAll("[}]"," ");
        strMatrix = strMatrix.trim();
        String[] MatrixRows = strMatrix.split(" , ");

        //Ищем кол-во колонок
        String[] row = MatrixRows[0].split(",");
        int columnNum = row.length;

        //Заполнение матрицы элементами
        double[][] newMatrix = new double [MatrixRows.length][columnNum];
        for (int i = 0; i < MatrixRows.length ; i++)
        {
            String[] rowArray = MatrixRows[i].split(",");
            for (int j = 0; j < columnNum; j++)
            {
                newMatrix[i][j]=Double.parseDouble(rowArray[j]);
            }
        }
        this.value = newMatrix;
    }
    Matrix(Matrix Matrix)
    {
        double[][] newMatrix = new double[Matrix.value.length][Matrix.value[0].length];
        for (int i = 0; i < Matrix.value.length; i++)
        {
            System.arraycopy(Matrix.value[i],0,newMatrix[i],0,Matrix.value[0].length);
        }
        this.value=newMatrix;
    }
    @Override
    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder("{ { ");
        String limiter="";
        for (int i = 0; i < value.length; i++)
        {
            for (int j = 0; j < value[0].length; j++)
            {
                if(j==0)
                    limiter="";
                stringBuilder.append(limiter).append(value[i][j]);
                limiter=", ";
            }
            if (i<=value.length-2)
            {
                stringBuilder.append(" }, { ");
            }
        }
        stringBuilder.append(" } }");
        return stringBuilder.toString();
    }
}
