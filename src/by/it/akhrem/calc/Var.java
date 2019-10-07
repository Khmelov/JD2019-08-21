package by.it.akhrem.calc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    static ResMan rm = ResMan.INSTANCE;

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static void printvar(){
        for(Map.Entry<String, Var> entry: vars.entrySet())
            System.out.println(entry.getKey()+"=" + entry.getValue());
    }


    static Var createVar(String strVar) throws CalcException{
        strVar = strVar.replace(" ", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException(rm.get("Var.ErrCannotCreate") + " " + strVar);
    }

    @Override
    public String toString() {
        return "{Abstract var}";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(rm.get("Var.ErrOperation") + " " + this + " + " + other + rm.get("Var.ErrUnavailable")+ "\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(rm.get("Var.ErrOperation") + " " + this + " + " + other + rm.get("Var.ErrUnavailable")+ "\n");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(rm.get("Var.ErrOperation") + " " + this + " + " + other + rm.get("Var.ErrUnavailable")+ "\n");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(rm.get("Var.ErrOperation") + " " + this + " + " + other + rm.get("Var.ErrUnavailable")+ "\n");
    }
}
