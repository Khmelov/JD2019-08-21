package by.it.shamuradova.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final HashMap<String, Integer> priopTable = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getIndex(List<String> operations) {
        int index = -1;
        int prioritet = -1; //перебираем, если наткнулись на операцию, в которой приоритет выше, значит обновляем индекс и приоритет
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (prioritet < priopTable.get(operation)) {
                index = i;
                prioritet = priopTable.get(operation);
            }
        }
        return index;
    }

    Var calcOneOperation(String strOne, String operation, String strTwo) throws CalcException {

        if (operation.contains("=")) {
            Var two = Var.createVar(strTwo);
            Var.save(strOne, two);
            return two;
        }
        //если вычисляется что-то
        Var one = Var.createVar(strOne);
        Var two = Var.createVar(strTwo);
        switch (operation) {
            case "+":
                return one.add(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
            case "-":
                return one.sub(two);
        }
        throw new CalcException("unknown operation" + operation);  //выбросится исключение, если в case попалась операция, которой не существует
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        String[] parts = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(parts));
        List<String> operations = new ArrayList<>();
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher operationMatcher = operationPattern.matcher(expression);
        while (operationMatcher.find()) {
            operations.add(operationMatcher.group());
        }
        //закончим считать в момент, когда List operations будет пустым
        while (!operations.isEmpty()) {
            int index = getIndex(operations); //передадим все операции
            String operation = operations.remove(index);  //вытащили из массива
            String onePart = operands.remove(index);
            String twoPart = operands.remove(index);
            //вытащили все части можно получить результат выражения
            Var tempResult = calcOneOperation(onePart, operation, twoPart);
            operands.add(index, tempResult.toString());

        }
        return Var.createVar(operands.get(0));
    }
}


