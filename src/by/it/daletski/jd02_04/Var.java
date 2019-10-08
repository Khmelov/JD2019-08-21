package by.it.daletski.jd02_04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName()
                .replace(".", File.separator)
                .replace(taskAClass.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }


    private static Map<String, Var> map = new HashMap<>();
    //a=3
    //b={1,2,3}
    //c=4
    private static String filename = getPath(Var.class).concat("vars.txt");


    static void saveVars() throws CalcException {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(filename))
        ) {
            for (Map.Entry<String, Var> pair : map.entrySet()) {
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


    @Override
    public Var add(Var other) throws CalcException {
        String message = String.format("Операция %s + %s невозможна.\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        String message = String.format("Операция %s - %s невозможна.\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        String message = String.format("Операция %s * %s невозможна.\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.printf("Операция %s / %s невозможна.\n", this, other);
        String message = String.format("Операция %s + %s невозможна.\n", this, other);
        throw new CalcException(message);
    }

    @Override
    public String toString() {
        return "{Abstract var}";
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (map.containsKey(strVar)) {
            return map.get(strVar);
        }
        throw new CalcException(" unknow expression: " + strVar);
    }

    static void save(String name, Var var) throws CalcException {
        map.put(name, var);
    }
}
