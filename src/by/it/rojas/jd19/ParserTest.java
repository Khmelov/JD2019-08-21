package by.it.rojas.jd19;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkScalar() throws CalcException {

        String expression= "A=2+5.3";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected ="7.3";
        assertEquals(expected,actual);

        expression= "B=A*3.5";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="25.55";
        assertEquals(expected,actual);

        expression= "B1=B+0.11*-5";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="25.0";
        assertEquals(expected,actual);

        expression= "B1=B+0.11*-5";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="25.0";
        assertEquals(expected,actual);

        expression= "B2=A/2-1";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="2.65";
        assertEquals(expected,actual);

    }
    @Test
    public void checkVector() throws CalcException {

        String expression= "{2,3,4}*-2";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected ="{-4.0, -6.0, -8.0}";
        assertEquals(expected,actual);

        expression= "{3,6,9}/-3";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{-1.0, -2.0, -3.0}";
        assertEquals(expected,actual);

        expression= "{-2,3,4}+{5,6,7}";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{3.0, 9.0, 11.0}";
        assertEquals(expected,actual);

        expression= "{5,6,7}-{-2,-3,4}";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{7.0, 9.0, 3.0}";
        assertEquals(expected,actual);
    }
    @Test
    public void checkMatrix() throws CalcException {

        String expression= "{{1,2},{-8,3}}-2";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected ="{{-1.0, 0.0}, {-10.0, 1.0}}";
        assertEquals(expected,actual);

        expression= "{{1,2},{8,3}}*{1,-2}";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{-3.0, 2.0}";
        assertEquals(expected,actual);

        expression= "{{1,2},{-8,3}}*{{1,2},{8,-3}}";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{{17.0, -4.0}, {16.0, -25.0}}";
        assertEquals(expected,actual);

        expression= "{{1,2},{8,-3}}+{{1,2},{8,3}}";
        parser = new Parser();
        actual = parser.calc(expression).toString();
        expected ="{{2.0, 4.0}, {16.0, 0.0}}";
        assertEquals(expected,actual);
    }
}