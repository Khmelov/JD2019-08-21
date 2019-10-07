package by.it.agadzhanov.jd02_05_calculator6;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();
    private static ResourceManager resMan = ResourceManager.INSTANCE;

    static Var saveVar(String name, Var var) {
        variables.put(name, var);
        return var;
    }

    static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace(" ", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (variables.containsKey(operand))
            return variables.get(operand);
        throw new CalcException(resMan.getString(Message.IMPOSSIBLE_TO_CREATE));
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resMan.getString(Message.IMPOSSIBLE_TO_ADD));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resMan.getString(Message.IMPOSSIBLE_TO_SUB));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resMan.getString(Message.IMPOSSIBLE_TO_MUL));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resMan.getString(Message.IMPOSSIBLE_TO_DIV));
    }
}
