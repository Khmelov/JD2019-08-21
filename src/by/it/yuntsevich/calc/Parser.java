package by.it.yuntsevich.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private final HashMap<String,Integer> map = new HashMap<String,Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };
    private int getIndex(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (pr< map.get(operation)){
                index = i;
                pr = map.get(operation);
            }
        }
        return index;
    }

    private String calcOneOperation(String left, String operation, String right) throws CalcException{
        Var two = Var.createVar(right);
        if (operation.equals("=")){
            Var.saveVar(left,two);
            return two.toString();
        }
        Var one = Var.createVar(left);
            switch (operation) {
                case "+":
                    return one.add(two).toString();
                case "-":
                    return one.sub(two).toString();
                case "*":
                    return one.mul(two).toString();
                case "/":
                    return one.div(two).toString();
            }
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATION) + operation);
    }


    Var calc(String expression) throws CalcException{
        expression = expression.replaceAll("\\s+", "");
        char[] expressionCh = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        int i1 = 0;
        int i2 = 0;
        int s = 0;
        for (int i = 0; i < expressionCh.length; i++) {
            if (expressionCh[i] == '(') {
                if (!start) {
                    s = i + 1;
                }
                start = true;
                i1++;
            } else if (expressionCh[i] == ')') {
                i2++;
            }
            if (!start) {
                sb.append(expressionCh[i]);
            }
            if (start && (i1 - i2 == 0)) {
                start = false;
                char[] chars = Arrays.copyOfRange(expressionCh, s, i);
                String s1 = String.valueOf(chars);
                Var calc = calc(s1);
                String s2 = calc.toString();
                sb.append(s2);
            }
        }
        expression = sb.toString();


        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOperation.matcher(expression);
        while(matcher.find())
            operations.add(matcher.group());

        while (!operations.isEmpty()){
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String tmpResult = calcOneOperation(left, operation, right);
            operands.add(index,tmpResult);
        }
        return Var.createVar(operands.get(0));
    }


}
