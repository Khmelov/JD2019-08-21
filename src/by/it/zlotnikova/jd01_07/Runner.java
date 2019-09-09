package by.it.zlotnikova.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var v1 = new Scalar(3.14);
        Scalar v2 = new Scalar("5");
        Scalar v3 = new Scalar(v2);

        Vector v4 = new Vector(new double[]{1, 5, 7, 9});
        Var v5 = new Vector(v4);
        String str = "{1.0, 2.0, 4.0}";
        Var v6 = new Vector(str);

        Matrix v7 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Var v8 = new Matrix(v7);
        Var v9 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
    }
}

