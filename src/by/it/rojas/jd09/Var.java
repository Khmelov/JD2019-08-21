package by.it.rojas.jd09;

abstract class Var  implements Operation {

    public double[][] Value;

    static Var createVar (String operand){
        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " +this+ " + " +other+ " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " +this+ " - " +other+ " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " +this+ " * " +other+ " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " +this+ " / " +other+ " невозможно");
        return null;
    }
}
