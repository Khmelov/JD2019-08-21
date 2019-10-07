package by.it.agadzhanov.jd02_06_calculator7;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();
    private static ResourceManager resourceManager = ResourceManager.INSTANCE;

    static Var saveVar(String name, Var var) {
        variables.put(name, var);
        return var;
    }

    static void printVar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static Var createVar(String operand) throws CalculationException {
        VarCreator varCreator = VarSelector.selectCreator(operand);
        if (varCreator == null) {
            if (variables.containsKey(operand)) {
                return variables.get(operand);
            }
            else throw new CalculationException(resourceManager.getString(Message.IMPOSSIBLE_TO_CREATE));
        }
        return varCreator.getVar(operand);
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalculationException {
        throw new CalculationException(resourceManager.getString(Message.IMPOSSIBLE_TO_ADD));
    }

    @Override
    public Var sub(Var other) throws CalculationException {
        throw new CalculationException(resourceManager.getString(Message.IMPOSSIBLE_TO_SUB));
    }

    @Override
    public Var mul(Var other) throws CalculationException {
        throw new CalculationException(resourceManager.getString(Message.IMPOSSIBLE_TO_MUL));
    }

    @Override
    public Var div(Var other) throws CalculationException {
        throw new CalculationException(resourceManager.getString(Message.IMPOSSIBLE_TO_DIV));
    }
}
