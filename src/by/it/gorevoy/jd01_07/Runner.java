package by.it.gorevoy.jd01_07;
public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar( "1.25");
        Var v2 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v1);
        System.out.println(v2);
        String s = "{{1,2,2},{3,4,2}}";
        Var v3 = new Matrix(s);
        System.out.println(v3);
    }
}
