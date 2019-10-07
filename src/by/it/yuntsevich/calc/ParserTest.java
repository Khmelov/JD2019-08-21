package by.it.yuntsevich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkAllOperations() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("7.3", actual.toString());

        actual = parser.calc("B=A*3.5");
        assertEquals("25.55", actual.toString());

        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", actual.toString());

        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65", actual.toString());

        actual = parser.calc("C=B+(A*2)");
        assertEquals("40.15", actual.toString());

        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actual.toString());

        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", actual.toString());

        actual = parser.calc("{{1,2},{3,4}}*{1,1}");
        assertEquals("{3.0, 7.0}", actual.toString());

        actual = parser.calc("{{4,3},{2,1}}*{5,11}");
        assertEquals("{53.0, 21.0}", actual.toString());

        actual = parser.calc("{{1,2},{3,4}}+{{1,2},{3,4}}");
        assertEquals("{{2.0, 4.0}, {6.0, 8.0}}", actual.toString());
    }
}