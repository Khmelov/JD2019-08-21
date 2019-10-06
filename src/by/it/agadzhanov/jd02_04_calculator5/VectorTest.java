package by.it.agadzhanov.jd02_04_calculator5;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void vectorAdd() {
        String expression = "A={10,9,8}+{-5,6,0}";
        String expected = "{5.0, 15.0, 8.0}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorSub() {
        String expression = "A={-4,8,0}-{-5,9,-15}";
        String expected = "{1.0, -1.0, 15.0}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorMul() {
        String expression = "A={4,7,2}*{3.5,2,5.5}";
        String expected = "39.0";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorDiv() {
        String expression = "A={1,1,1}/4";
        String expected = "{0.25, 0.25, 0.25}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorCombined() {
        String expression = "A={1,2,3}/(({4,5,6}-{-2,0,1})*{-1,-1,2})+{0,5,2}";
        String expected = "{-1.0, 3.0, -1.0}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorToString() {
        Var vector = Var.createVar("{1,2,3,4,5,6}");
        String expected = "{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}";
        String actual = vector.toString();
        assertEquals(expected,actual);
    }
}