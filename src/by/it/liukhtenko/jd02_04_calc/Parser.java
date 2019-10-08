package by.it.liukhtenko.jd02_04_calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final HashMap<String, Integer> prTable = new HashMap<String, Integer>() {
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
            if (pr<prTable.get(operation)){
                index = i;
                pr = prTable.get(operation);
            }
        }
        return index;
    }

    private Var calcOneOperation(String strOne,String operation,String strTwo) throws CalcException {
        if(operation.contains("=")){
            Var two = Var.createVar(strTwo);
            Var.saveVar(strOne,two);
            return two;
        }
        Var one = Var.createVar(strOne);
        Var two = Var.createVar(strTwo);


            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        throw  new CalcException("Unknown operation: "+operation);
    }


    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ","");
        String [] operand = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(operand));
        List<String> operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find())
            operations.add(m.group());
        while (!operations.isEmpty()){
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var tmp = calcOneOperation(left, operation, right);
            operands.add(index,tmp.toString().replaceAll(" ",""));
        }
        return Var.createVar(operands.get(0));
}
}
