package by.it.akhmelev.jd02_04_calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void checkSacalarOperations() throws Exception {
        String expression="A=2+5.3";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected="7.3";
        assertEquals(expected,actual);

    }

}