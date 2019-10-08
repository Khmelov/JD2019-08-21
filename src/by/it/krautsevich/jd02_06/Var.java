package by.it.krautsevich.jd02_06;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>() ;

    static Var saveVar (String name , Var var) {
        vars.put(name , var);
        return  var ;}

    static Map <String, Var> giveMap () {
        return vars ; }

    public static Var createVar(String strVar) throws CalcException {
 /*       if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar) ;
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar) ;
        else if (vars.containsKey(strVar))
            return vars.get(strVar) ;

        return null ;       */

        VarCreator varCreator = VarSelector.selectCreator(strVar) ;
        if (varCreator == null) {
            if (vars.containsKey(strVar)) {
                return vars.get(strVar);
            } else throw new CalcException("Не удалось создать переменную");
        }
        else return varCreator.getVar(strVar) ;
    }

    @Override
    public Var add(Var other) throws CalcException {
        System.out.printf("Операция %s + %s невозможна.\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.printf("Операция %s - %s невозможна.\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.printf("Операция %s * %s невозможна.\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.printf("Операция %s / %s невозможна.\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "{abstract var}" ;
            }
}
