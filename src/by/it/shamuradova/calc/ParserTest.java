package by.it.shamuradova.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkScalarOperationSum() throws Exception{
        String expression="A=2+5.3";
        Parser parser= new Parser();
        String actual = parser.calc(expression).toString();
        String expected = "7.3";
        assertEquals(expected, actual);
    }




    @Test
    public void checkScalarOperationSub() throws Exception{
        String expression="B=2-2";
        Parser parser= new Parser();
        String actual = parser.calc(expression).toString();
        String expected = "0.0";
        assertEquals(expected, actual);
    }

}