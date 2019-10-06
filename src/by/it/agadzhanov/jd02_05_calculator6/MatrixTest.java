package by.it.agadzhanov.jd02_05_calculator6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void matrixAdd() throws CalcException {
        String expression = "A={{1,2},{3,4}}+{{4,3},{2,1}}";
        String expected = "{{5.0, 5.0}, {5.0, 5.0}}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixSub() throws CalcException {
        String expression = "A={{1,2},{3,4}}-{{-4,3},{-2,1}}";
        String expected = "{{5.0, -1.0}, {5.0, 3.0}}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMul() throws CalcException {
        String expression = "A={{1,2},{3,4}}*{{4,3},{2,1}}";
        String expected = "{{8.0, 5.0}, {20.0, 13.0}}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixDiv() throws CalcException {
        String expression = "A={{1,2},{6,4}}/4";
        String expected = "{{0.25, 0.5}, {1.5, 1.0}}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixCombined() throws CalcException {
        String expression = "A=({{1,0},{0,1}}*{{4,3},{2,1}}+{{-4,-3},{-2,-1}}-{{2,1},{2,1}})/4";
        String expected = "{{-0.5, -0.25}, {-0.5, -0.25}}";
        Parser parser = new Parser();
        String actual = parser.calculateExpression(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixToString() throws CalcException {
        Var matrix = Var.createVar("{{1,2,3},{4,5,6},{7,8,9}}");
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}";
        String actual = matrix.toString();
        assertEquals(expected,actual);
    }
}