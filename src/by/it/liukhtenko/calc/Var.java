package by.it.liukhtenko.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

   private static Map<String,Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar (String name, Var var){
       vars.put(name,var);
       return var;
   }
    static void printvar (){
        for (String s : vars.keySet()) {
            String key = s.toString();
            String value = vars.get(s).toString();
            System.out.println(key + "=" + value);

        }

    }
    static void sortvar (){
        Map<String,Var> vars = new TreeMap<>(getVars());
        for (String s : vars.keySet()) {
            String key = s.toString();
            String value = vars.get(s).toString();
            System.out.println(key + "=" + value);
        }

    }

    static Var createVar(String operand) throws  CalcException{
        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if(vars.containsKey(operand))
            return vars.get(operand);

        throw  new CalcException("Невозможно создать "+operand);
    }
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения"+ this+"+"+other+"невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания"+ this+"-"+other+"невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения"+ this+"*"+other+"невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления"+ this+"/"+other+"невозможна");
    }

    @Override
    public String toString() {
        return "это класс Var";
    }
}
