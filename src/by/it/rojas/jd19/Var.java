package by.it.rojas.jd19;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {


    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName()
                .replace(".", File.separator)
                .replace(taskAClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }


    private static Map<String, Var> vars = new HashMap<>();
    private static String filename = getPath(Var.class).concat("vars.txt");

    public static Map<String, Var> getVars() {
        return vars;
    }

    static void saveVars() throws CalcException {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(filename))
        ) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.println(pair.getKey() + "=" + pair.getValue());
            }
            writer.flush();
        } catch (IOException e) {
            throw new CalcException(" not write file: " + filename, e);
        }
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

    static Var saveVar(String name, Var var) throws CalcException {
        vars.put(name, var);
        saveVars();
        return var;
    }


    static void printvar() {
        for (String s : vars.keySet()) {
            String key = s.toString();
            String value = vars.get(s).toString();
            System.out.println(key + "=" + value);

        }

    }

    static void sortvar() {
        Map<String, Var> vars = new TreeMap<>(getVars());
        for (String s : vars.keySet()) {
            String key = s.toString();
            String value = vars.get(s).toString();
            System.out.println(key + "=" + value);
        }

    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand)) {
            return vars.get(operand);
        }
        throw new CalcException("Невозможно создать " + operand);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения" + this + "+" + other + "невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания" + this + "-" + other + "невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения" + this + "*" + other + "невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления" + this + "/" + other + "невозможна");
    }

    @Override
    public String toString() {
        return "это класс Var";
    }
}
