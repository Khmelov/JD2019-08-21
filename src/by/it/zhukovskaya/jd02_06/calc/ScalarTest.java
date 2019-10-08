package by.it.zhukovskaya.jd02_06.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest {

    @Test
    public void scalarAdd() throws CalculationException {
        String expression = "A=13.2+7";
        String expected = "20.2";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarSub() throws CalculationException {
        String expression = "A=15.7-11.2";
        String expected = "4.5";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarMul() throws CalculationException {
        String expression = "A=2.25*8";
        String expected = "18.0";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarDiv() throws CalculationException {
        String expression = "A=7.5/1.5";
        String expected = "5.0";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarCombined() throws CalculationException {
        String expression = "A=10-6/3+2*4";
        String expected = "16.0";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarToString() throws CalculationException {
        Var scalar = Var.createVar("123.456");
        String expected = "123.456";
        String actual = scalar.toString();
        assertEquals(expected,actual);
    }
}