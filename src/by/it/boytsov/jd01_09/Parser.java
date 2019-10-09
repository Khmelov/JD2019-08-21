package by.it.boytsov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser
{
    Var calc(String expression)
    {
        String[] operand = expression.split(Patterns.OPERATION);
        Var firstVar = Var.createVar(operand[0]);
        Var secondVar=Var.createVar(operand[1]);
        if(firstVar==null||secondVar==null)
            return null;
        Pattern pattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher=pattern.matcher(expression);
        if(matcher.find())
        {
            String operation = matcher.group();
            switch(operation)
            {
                case "+": return firstVar.add(secondVar);
                case "-": return firstVar.sub(secondVar);
                case "*": return firstVar.mul(secondVar);
                case "/": return firstVar.div(secondVar);
            }
        }
        return null;
    }
}
