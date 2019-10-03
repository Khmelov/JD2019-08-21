package by.it.rojas.calc;

abstract class Var  implements Operation {



    static Var createVar (String operand) throws CalcException{
        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        throw  new CalcException("Невозможно создать " +operand);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " +this+ " + " +other+ " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания " +this+ " - " +other+ " невозможно");

    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения " +this+ " * " +other+ " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления " +this+ " / " +other+ " невозможно");
    }

    @Override
    public String toString() {
        return "это класс Var";
    }
}
