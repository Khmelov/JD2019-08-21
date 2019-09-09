package by.it.rubatskii.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar s1=new Scalar(3.1415);
        System.out.println(s1);
        Scalar s2=new Scalar(s1);
        System.out.println(s2);
        Scalar s3=new Scalar("123.222");
        System.out.println(s3);
        double[] array={1,2,3,4,0};
        Var v1=new Vector(array);
        System.out.println(v1);
    }


}
