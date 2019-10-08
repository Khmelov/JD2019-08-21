package by.it.krautsevich.jd02_04;

import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void checkAdd() throws CalcException {
        String expression = "{1,2,3}+1" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "{2.0, 3.0, 4.0}" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSub() throws CalcException {
        String expression = "{1,2,3}-1" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "{0.0, 1.0, 2.0}" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkMul() throws CalcException {
        String expression = "{1,2,3}*3" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "{3.0, 6.0, 9.0}" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkDiv() throws CalcException {
        String expression = "{3.0, 6.0, 9.0}/3" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "{1.0, 2.0, 3.0}" ;
        assertEquals(expected, actual);
    }

    @Test
    public void checkSave() throws CalcException {
        String expression = "A = {3.0, 6.0, 9.0}" ;
        Parser parser = new Parser() ;
        String actual = parser.calc(expression).toString() ;
        String expected = "{3.0, 6.0, 9.0}" ;
        assertEquals(expected, actual);
    }

}