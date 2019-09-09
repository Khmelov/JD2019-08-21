package by.it.zavadski.jd01_08;



public class Runner {
    private static void print(Var var) { System.out.println(var);}
    public static void main(String[] args) {
        Var s=new Scalar(3.0);
        Var v=new Vector(new double[]{1,2,3});
        Var m=new Matrix(new double[][]{{1,2,3},{4,5,6}});

        print(s.add(s)); //выведет в консоль 6.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s));

        print(v.add(v));
        print(v.sub(v));
        print(v.mul(v));
        print(v.div(v));

        print(m.add(v));
        print(m.sub(v));
        print(m.mul(v));
        print(m.div(v));
    }
}
