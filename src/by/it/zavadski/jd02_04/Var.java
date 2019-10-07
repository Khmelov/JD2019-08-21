package by.it.zavadski.jd02_04;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import by.it.zavadski.jd02_05.ResourceManager;

abstract class Var implements Operation {

    private static String filename = getPath(Var.class).concat("vars.txt");
    private static Map<String, Var> vars=new HashMap<>();
    static Var saveVar(String name, Var var){
    vars.put(name, var);
    return var;

}
     static Var createVar(String strVar) throws CalcException {
         strVar=strVar.trim().replace("\\s+","");
        if(strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if(strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if(strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException("Невозможно создать "+strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
    throw new CalcException("Операция сложения "+ this+"+" + other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+ this+"-" + other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+ this+"*" + other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+ this+":" + other+" невозможна");
    }

    public String toString(){return "Abstract class Var";}

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName()
                .replace(".", File.separator)
                .replace(taskAClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

}
