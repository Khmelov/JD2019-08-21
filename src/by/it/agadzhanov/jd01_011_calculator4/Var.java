package by.it.agadzhanov.jd01_011_calculator4;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    static Var saveVar(String name, Var var) {
        variables.put(name, var);
        return var;
    }

    static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static void sortVar() {

    }

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (variables.containsKey(operand))
            return variables.get(operand);
        return null;  //TODO create error
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " из " + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }
}
