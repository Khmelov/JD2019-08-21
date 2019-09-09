package by.it.kiturka.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1 =new Scalar(3.14569626);
        Scalar s2=new Scalar(s1);
        Scalar s3 = new Scalar("3.14569626");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Vector v1 = new Vector(new double [] {1,2,3,4});
        System.out.println(v1);
        Vector v2 = new Vector (v1);
        System.out.println(v2);
        Vector v3 = new Vector("{1,2,3,4,5,6}");
        System.out.println(v3);

        double [] [] array = {{1, 2, 3}, {1, 2, 5}, {1, 8, 9}};




    }
}
