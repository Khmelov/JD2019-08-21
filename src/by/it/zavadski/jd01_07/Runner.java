package by.it.zavadski.jd01_07;

import javax.sound.midi.Soundbank;

public class Runner {
    public static void main(String[] args) {
        Scalar s1=new Scalar(3.14156926);
        System.out.println(s1);

       // Scalar s2=new Scalar(s1);
        Var s2=new Scalar(s1);
        System.out.println(s2);

        Scalar s3=new Scalar("1234.5678");
        System.out.println(s3);

        double[] array={1,2,3,5,6,7};
        Var v1=new Vector(array);
        System.out.println(v1);

        Vector v3 = new Vector("{1,2,3}");
        System.out.println(v3);

        double[][] array2D={{1.0,2.0},{3.0,4.0}};
        Matrix m1=new Matrix(array2D);

    }
}
