package by.it.daletski.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    Var calc(String expression)throws CalcException {

        List<String> operands= new ArrayList<> ();


        String[] operand=expression.split (Patterns.OPERATION);

        Var one = Var.createVar (operand[0]);
        Var two = Var.createVar (operand[1]);
        if (one==null || two==null)
            return null; //TODO create error
        Pattern p = Pattern.compile (Patterns.OPERATION);
        Matcher m = p.matcher (expression);
        if (m.find()){
            String operation = m.group ();
            switch (operation){
                case "+": return one.add (two);
                case "-": return one.sub (two);
                case "*": return one.mul (two);
                case "/": return one.div (two);
            }
        }
        return null;
    }
}
