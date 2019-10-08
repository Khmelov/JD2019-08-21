package by.it.krautsevich.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final HashMap<String , Integer> priorityTable = new HashMap<String , Integer>(){
        {
            this.put("=" , 0) ;
            this.put("+" , 1) ;
            this.put("-" , 1) ;
            this.put("*" , 2) ;
            this.put("/" , 2) ;

        }
    } ;

    private int getIndex(List<String> operations) {
        int index = -1 ;
        int prior = -1 ;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i) ;
            if (prior < priorityTable.get(operation))
            {index = i ;
            prior = priorityTable.get(operation) ; }
        }
        return index ;
    }

        private Var calcOneOperation (String strOne , String operation , String strTwo) throws CalcException {



        if (operation.contains("=")) {
            Var two = Var.createVar(strTwo);
            Var.saveVar(strOne, two);
            return Var.saveVar(strOne , two); }

        Var one = Var.createVar(strOne) ;
        Var two = Var.createVar(strTwo) ;

            switch (operation) {
                case "+" : return one.add(two) ;
                case "-" : return one.sub(two) ;
                case "*" : return one.mul(two) ;
                case "/" : return one.div(two) ; }

        throw new CalcException("Unknown operation: "  + operation); }


    Var calc (String expression) throws CalcException {

        expression = expression.replace(" " , "") ;

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

        String[] parts = expression.split(Patterns.OPERATIONS) ;
        List<String> operands = new ArrayList<>(Arrays.asList(parts)) ;
        List<String> operations = new ArrayList<>() ;
        Pattern patternOperation = Pattern.compile(Patterns.OPERATIONS) ;
        Matcher matcher = patternOperation.matcher(expression);
        while (matcher.find())
            operations.add(matcher.group()) ;
        while (operations.size()>0){
            int index = getIndex(operations) ;
            String operation = operations.remove(index) ;
            String left = operands.remove(index) ;
            String right = operands.remove(index) ;
            Var tmpRes = calcOneOperation(left, operation, right) ;
            operands.add(index, tmpRes.toString());
        }

        return Var.createVar(operands.get(0).replace(" ", "")) ;
    }
}
