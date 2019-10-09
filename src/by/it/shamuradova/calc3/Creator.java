package by.it.shamuradova.calc3;

import java.util.HashMap;
import java.util.Map;

class Creator {
    private static Map<String, Var> vars = new HashMap<>();

    static Map<String, Var> getVars() {
        return vars;
    }


    static void save(String name, Var var) {
        vars.put(name, var);
    }

    public static Var createVar (String vyragenie) throws CalcException{
        if (vyragenie.matches(Patterns.SCALAR)) {
            return new Scalar(vyragenie);
        }
        if (vyragenie.matches(Patterns.VECTOR)){
            return new Vector(vyragenie);
        }
        if (vyragenie.matches(Patterns.MATRIX)){
            return new Matrix(vyragenie);
        }
        if(vars.containsKey(vyragenie)){
            return vars.get(vyragenie);
        }
        throw new CalcException(ResManager.INSTANCE.getKey(Message.CREATION));
    }
}
