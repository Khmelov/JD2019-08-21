package by.it.yuntsevich.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String subPath = Var.class.getName().replace(".", File.separator).replace(Var.class.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

    private static void saveVarsToFile() throws CalcException {
        String fileName = getPath().concat("vars.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.println(pair.getKey() + " = " + pair.getValue());
            }

        } catch (IOException e) {
            throw new CalcException(ResourceManager.INSTANCE.get(Messages.FILE) + fileName, e);
        }
    }

    static void readVars() {
        String fileName = getPath().concat("vars.txt");
        Parser tmpParser = new Parser();
        try {
            Files.lines(Paths.get(fileName)).forEach(expression-> {
                try {
                    tmpParser.calc(expression);
                } catch (CalcException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar)) {
            saveVarsToFile();
            return vars.get(strVar);
        }
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.CREATION) + strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "+" + other );
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "-" + other);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "*" + other);

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "/" + other);

    }

    @Override
    public String toString() {
        return "{Abstract var}";

    }


}

