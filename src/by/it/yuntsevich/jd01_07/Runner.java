package by.it.yuntsevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1 = new Scalar(3.1415);
        System.out.println(s1);
        Scalar s2 = new Scalar(s1);
        System.out.println(s2);
        Scalar s3 = new Scalar(1234.5678);
        System.out.println(s3);

        double [] array = {1,2,3,4,5,6,7};
        Vector v1 = new Vector(array);
        System.out.println(v1);
        Vector v2 = new Vector(v1);
        System.out.println(v2);
        Vector v3 = new Vector("{1,2,3,4}");
        System.out.println(v3);

        double [][] matrix = {{1,2},{4,5}};
        Matrix m1 = new Matrix(matrix);
        System.out.println(m1);
        Matrix m2 = new Matrix(m1);
        System.out.println(m2);
        Matrix m3 = new Matrix("{{1,2,3,8}, {3,4,5,6}}");
        System.out.println(m3);

    }
}
