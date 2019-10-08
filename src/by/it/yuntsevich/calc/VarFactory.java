package by.it.yuntsevich.calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

class VarFactory {
    private static Map<String, Var> vars = new HashMap<>();

    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String subPath = Var.class.getName().replace(".", File.separator).replace(Var.class.getSimpleName(), "");
        return rootProject + File.separator + "src" + File.separator + subPath;
    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Logger.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "log.txt";
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
    static void load() throws CalcException {
        Parser p = new Parser();
        File file = new File(getFileName());
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    p.calc(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
