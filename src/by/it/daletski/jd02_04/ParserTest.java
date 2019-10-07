package by.it.daletski.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void checkSacalarOperations() throws Exception {
        String expression = "A=2+5.3";
        Parser parser = new Parser ();
        String actual = parser.calc (expression).toString ();
        String expected = "7.3";
        assertEquals (expected, actual);

    }

    @Test
    public void checkVectorAddScalar() throws Exception {
        Var var = parser.calc ("A={1,2}+3");
        String expected = "{4.0, 5.0}";
        String actual = var.toString ();
        assertEquals (expected, actual);
    }

    @Test
    public void checkVectorSubVector() throws Exception {
        Var var = parser.calc ("A={3,4}-{1,2}");
        String actual = var.toString ();
        String expected = "{2.0, 2.0}";
        assertEquals (expected, actual);


    }
    @Test
    public void checkVectorSubScalar() throws Exception {
        Var var = parser.calc("A={2,3}-1");
        String actual = var.toString();
        String expected = "{1.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkBrackets() throws Exception{
        Var varA = parser.calc("A=2+5.3");
        Var varB = parser.calc("B="+varA.toString()+"*5.3");
        Var varC = parser.calc("C="+varB.toString()+"("+varA.toString()+"*5)");
        Var varD = parser.calc("D=(("+varC.toString()+"-0.15)-20)/(7-5)");
        Var varE = parser.calc("E={2,3}*("+varD.toString()+"/2)");
        String expected = "{10,15}";
        String actual = varE.toString();
        assertEquals(expected, actual);
    }


}