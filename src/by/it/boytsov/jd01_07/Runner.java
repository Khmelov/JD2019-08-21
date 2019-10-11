package by.it.boytsov.jd01_07;

public class Runner
{
    public static void main(String[] args)
    {
        //TaskA
        Scalar stepA1=new Scalar(3.1415);
        Var stepA2=new Scalar(stepA1);
        Var stepA3=new Scalar("3.1415");
        System.out.println(stepA1);
        System.out.println(stepA2);
        System.out.println(stepA3);


        //TaskB
        Vector stepB1=new Vector(new double[]{1,2,4});
        Var stepB2=new Vector(stepB1);
        Var stepB3=new Vector("{1,2,4}");
        System.out.println(stepB1);
        System.out.println(stepB2);
        System.out.println(stepB3);

        //TaskC
        Matrix stepC1=new Matrix(new double[][]{{1,2},{3,4}});
        Var stepC2=new Matrix(stepC1);
        Var stepC3=new Matrix("{{1,2},{3,4}}");
        System.out.println(stepC1);
        System.out.println(stepC2);
        System.out.println(stepC3);
    }
}
