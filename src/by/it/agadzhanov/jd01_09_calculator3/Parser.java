package by.it.agadzhanov.jd01_09_calculator3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] operands = expression.split(Patterns.operation);
        Var one = Var.createVar(operands[0]);
        if (operands.length == 1)
            return Var.createVar(expression);
        Var two = Var.createVar(operands[1]);
        if (one == null || two == null)
            return null;  //TODO create error
        Pattern operationPattern = Pattern.compile(Patterns.operation);
        Matcher matcherOperation = operationPattern.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
