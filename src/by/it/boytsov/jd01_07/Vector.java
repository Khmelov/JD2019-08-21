package by.it.boytsov.jd01_07;

public class Vector extends Var
{
    private double[] value;

    Vector(double[] value)
    {
        double[] newVector = new double[value.length];
        System.arraycopy(value,0,newVector,0,value.length);
        this.value=newVector;
    }
    Vector(String strVector)
    {
        strVector = strVector.replaceAll("[{]"," ");
        strVector = strVector.replaceAll("[}]"," ");
        strVector = strVector.replaceAll("[,]"," ");
        strVector = strVector.trim();
        String[] strVectorArray= strVector.split(" ");
        double[] VectorArray=new double[strVectorArray.length];
        for (int i = 0; i < VectorArray.length ; i++)
        {
            VectorArray[i]=Double.parseDouble(strVectorArray[i]);
        }
        this.value=VectorArray;
    }
    Vector(Vector Vector)
    {
        double[] newVector = new double[Vector.value.length];
        System.arraycopy(Vector.value,0,newVector,0,Vector.value.length);
        this.value=newVector;
    }
    @Override
    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder("{");
        String limiter="";
        for (double element: value)
        {
            stringBuilder.append(limiter).append(element);
            limiter=", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
