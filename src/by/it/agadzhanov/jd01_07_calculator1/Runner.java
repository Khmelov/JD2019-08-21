package by.it.agadzhanov.jd01_07_calculator1;

public class Runner {

    public static void main(String[] args) {
        Scalar s1=new Scalar(3.1415);
        Var s2=new Scalar(s1);
        Var s3=new Scalar("3.1415");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Vector v1=new Vector(new double[]{1,2,4});
        Var v2=new Vector(v1);
        Var v3=new Vector("{1,2,4}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        Matrix m1=new Matrix(new double[][]{{1,2},{3,4}});
        Var m2=new Matrix(m1);
        Var m3=new Matrix("{{1,2},{3,4}}");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
