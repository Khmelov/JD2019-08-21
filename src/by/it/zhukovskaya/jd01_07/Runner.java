package by.it.zhukovskaya.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1 = new Scalar(3.14156926);
        System.out.println(s1);
        Scalar s2 = new Scalar(s1);
        System.out.println(s2);
        Scalar s3 = new Scalar("1234.5678");
        System.out.println(s3);
        double [] array = {1, 2, 3, 4,5,6,7};
        Var v1 = new Vector(array);
        System.out.println(v1);
        Vector v2 = new Vector("{8, 9, 10, 11.5, 12.5}");
        System.out.println(v2);
        double [][] doubleArray = {{1,2,3}, {4,5,6}};
        Matrix v3 = new Matrix(doubleArray);
        System.out.println(v3);
        Var v4 = new Matrix(v3);
        System.out.println(v4);
        Var v5 = new Matrix("{{1, 4, 5}, {7, 8, 9}}");
        System.out.println(v5);
    }
}
