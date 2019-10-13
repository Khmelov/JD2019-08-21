package by.it.boytsov.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final Map<String, Integer> operationPriorities = new HashMap<String, Integer>() {
        {
            operationPriorities.put("*", 2);
            operationPriorities.put("/", 2);
            operationPriorities.put("+", 1);
            operationPriorities.put("-", 1);
            operationPriorities.put("=", 0);
        }
    };

    Var calculateExpression(String expression) {
        while (expression.contains("(")) {
            expression = simplifyExpression(expression);
        }
        expression = expression.trim().replace(" ", "");
        List<String> operands = new LinkedList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = operationPattern.matcher(expression);
        while (matcherOperation.find())
            operations.add(matcherOperation.group());

        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String right = operands.remove(index + 1);
            String left = operands.remove(index);
            Var tempResult = calculateOperation(left, right, operation);
            operands.add(index, tempResult.toString());
        }
        return Var.createVar(operands.get(0));
    }


    private String simplifyExpression(String expression) {
        Pattern partInBrackets = Pattern.compile(Patterns.PRIORITY);
        Matcher bracketsMatcher = partInBrackets.matcher(expression);
        if (bracketsMatcher.find()) {
            int start = bracketsMatcher.start();
            int end = bracketsMatcher.end();
            String expressionInBrackets = bracketsMatcher.group();
            expressionInBrackets = expressionInBrackets.replace("(", "").replace(")", "");
            Var result = calculateExpression(expressionInBrackets);
            expression = expression.replace(expression.substring(start, end), result.toString());
        }
        return expression;
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            int trialPriority = operationPriorities.get(operations.get(i));
            if (trialPriority > priority) {
                priority = trialPriority;
                index = i;
            }
        }
        return index;
    }

    private Var calculateOperation(String strLeft, String strRight, String operation) {
        Var right = Var.createVar(strRight);
        if (operation.equals("="))
            return Var.saveVar(strLeft,right);
        Var left = Var.createVar(strLeft);
        if (left == null || right == null)
            throw new NullPointerException();
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new NullPointerException();
    }
}