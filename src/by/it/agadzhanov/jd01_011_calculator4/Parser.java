package by.it.agadzhanov.jd01_011_calculator4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] operands = expression.split(Patterns.operation);
        if (operands.length == 1)
            return Var.createVar(expression);
        Var two = Var.createVar(operands[1]);
        if (expression.contains("=")) {
            return Var.saveVar(operands[0], two);
        }
        Var one = Var.createVar(operands[0]);
        if (one == null || two == null)
            return null;  //TODO create error
        Pattern operationPattern = Pattern.compile(Patterns.operation);
        Matcher matcherOperation = operationPattern.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}
