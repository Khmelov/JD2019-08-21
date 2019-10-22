package by.it.boytsov.jd02_04;

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
    public double[] getValue(){return value;}
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] + ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double [] result = new double [this.value.length];
            for  (int i = 0; i< this.value.length; i++)
                result[i] = this.value[i] + ((Vector) other).value[i];
            return new Vector(result);
        }
        return this.add(other);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] - ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double [] result = new double [this.value.length];
            for  (int i = 0; i< this.value.length; i++)
                result[i] = this.value[i] - ((Vector) other).value[i];
            return new Vector(result);
        }
        return this.sub(other);
    }
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] * ((Scalar) other).getValue();
            return new Vector(result);
        }
        if (other instanceof Vector) {
            double scalar = 0;
            for  (int i = 0; i< this.value.length; i++)
                scalar += this.value[i] * ((Vector) other).value[i];
            return new Scalar(scalar);
        }
        return this.mul(other);
    }
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double []result = new double [this.value.length];
            for (int i = 0; i < this.value.length; i++)
                result[i] = this.value[i] / ((Scalar) other).getValue();
            return new Vector(result);
        }
        return null;
    }
}
