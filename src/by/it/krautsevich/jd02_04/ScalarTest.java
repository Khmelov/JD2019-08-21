package by.it.krautsevich.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void checkMul() throws CalcException {
        String expression = "A = 2 + 5.3" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "7.3" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkRememberAndMul() throws CalcException {
        String expression = "B = A*3.5" ;
        String prev = "A= 7.3 " ;
        Parser parser = new Parser() ;
        parser.calc(prev) ;
        String actual = parser.calc(expression).toString() ;
        String expected = "25.55" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkRememberandAddAndMul() throws CalcException {
        String expression = "B1 = B + 0.11*-5" ;
        String prev = "B = 25.55 " ;
        Parser parser = new Parser() ;
        parser.calc(prev) ;
        String actual = parser.calc(expression).toString() ;
        String expected = "25" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkDiv() throws CalcException {
        String expression = "B2 = A/2-1";
        Parser parser = new Parser();
        String prev = "A = 7.3 " ;
        parser.calc(prev) ;
        String actual = parser.calc(expression).toString();
        String expected = "25.65";
        assertEquals(expected, actual);
    }

}