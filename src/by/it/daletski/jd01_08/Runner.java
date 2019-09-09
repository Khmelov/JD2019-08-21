package by.it.daletski.jd01_08;

public class Runner {
    private static void print(Var var) {
        System.out.println (var);
    }

    public static void main(String[] args) {
        Var s = new Scalar (3.0);
        Var v = new Vector (new double[]{1, 2, 3}); // закомментируйте вектор и/или
//Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        print (s.add (s)); //выведет в консоль 6.0
        print (s.sub (s)); //выведет в консоль 0.0
        print (s.mul (s)); //выведет в консоль 9.0
        print (s.div (s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        //print (v.add (v)); //выведет в консоль {2.0, 4.0, 6.0}
        //print (v.sub (v)); //выведет в консоль {0.0, 0.0, 0.0}
        //print (v.mul (v)); //выведет в консоль 14.0
        //print (v.div (v)); //сообщит о невозможности операции
    }
}