package by.it.shamuradova.calc;

import by.it.shamuradova.jd02_05.res.ResMan;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>(); //в случае операции "=", вычисления не выполняются, но переменная записывается в карту
    //ключ- название переменной String, значение Scalar, Vеctor, Matrix
    static ResManager manager = ResManager.INSTANCE;

    static Map<String, Var> getVars() {
        return vars;
    }

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName()
                .replace(".", File.separator)
                .replace(taskAClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }
    private static String filename = getPath(Var.class).concat("vars.txt");

    public static void saveVars () throws CalcException {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(filename))
        ) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.println(pair.getKey() + "=" + pair.getValue());
            }
            writer.flush();
        } catch (IOException e) {

            String fileNotA = manager.getKey(Message.FILE_HAS_NOT_BEEN_WRITTEN);
            throw new CalcException(fileNotA + filename, e);
        }
//        Var var = createVar(varExpression);
//        vars.put(key, var);
//        return var;
    }
    static void loadVars() throws IOException, CalcException {
        Parser tmpParser = new Parser();
        try (
                BufferedReader in = new BufferedReader(new FileReader(filename))
        ) {
            while (in.ready())
                tmpParser.calc(in.readLine());
        }
    }

    static void save(String name, Var var) {
        vars.put(name, var);
    }

//    public static void printVar() {
//        for (String a : vars.keySet()) {
//            System.out.println(a + "=" + vars.get(a));
//        }
//    }
//    public static void sortvar(){
//        Set<String> keys=new TreeSet<>(vars.keySet());
//        for (String key : keys) {
//            System.out.println(key + "="+ vars.get(key));
//        }
//    }

    @Override
    public String toString() {
        return manager.getKey(Message.VAR);
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(manager.getKey(Message.ADD) + this +"+" + other);
    }
    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(manager.getKey(Message.SUB) + this + "-" + other);
    }
    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(manager.getKey(Message.MUL) + this + "*" + other);

    }
    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(manager.getKey(Message.DIV) + this + "/" + other);
    }

    static Var createVar(String a){
        if (a.matches(Patterns.SCALAR)) {
            return new Scalar(a);
        }
        if (a.matches(Patterns.VECTOR)){
            return new Vector(a);
        }
        if (a.matches(Patterns.MATRIX)){
            return new Matrix(a);
        }
        if(vars.containsKey(a)){
            return vars.get(a);
        }
        return null;
    }
}
