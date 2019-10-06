package by.it.zlotnikova.jd02_04_calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void checkScalarAdd() {
        String expression = "2+5.3";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected = "7.3";
        assertEquals(expected, actual);
    }

    @Test
    public void checkScalarSub() {
        String expression = "18-2.6";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected = "15.4";
        assertEquals(expected, actual);
    }

    @Test
    public void checkScalarMul() {
        String expression = "1.5*5";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected = "7.5";
        assertEquals(expected, actual);
    }

    @Test
    public void checkScalarDiv() {
        String expression = "10/4";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected = "2.5";
        assertEquals(expected, actual);
    }
}