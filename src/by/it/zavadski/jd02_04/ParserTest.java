package by.it.zavadski.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private static Parser parser;
@BeforeClass
public static void initParser(){
    parser = new Parser();
}
    @Test
    public void checkSimpleCalc() throws Exception{
        String expression="A=3*3+1";
        String actual=parser.calc(expression).toString();
        String expected="10.0";
        assertEquals(expected,actual);
    }
    @Test

    public void checkCreationOfVar() throws Exception {
        String expression="A=2+2*2";
        String expected="6.0";
        parser.calc(expression);
        Var var=Var.createVar("A");
        assertEquals(expected, var.toString());
    }

    @Test
    public void checkScalarAddScalar() throws Exception {
        String expression="A=2+5.3";
        String actual=parser.calc(expression).toString();
        String expected="7.3";
        assertEquals(expected,actual);
    }
    @Test
    public void checkScalarSubScalar() throws Exception {
        String expression="A=100-89";
        String actual=parser.calc(expression).toString();
        String expected="11.0";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarDivScalar() throws Exception {
        String expression="A=1440/40";
        String actual=parser.calc(expression).toString();
        String expected="36.0";
        assertEquals(expected,actual);
    }

    @Test
    public void checkVectorAddScalar() throws Exception {
        Var var = parser.calc("A={1,2}+3");
        String expected = "{4.0, 5.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void checkOperationWithBrackets() throws Exception{
        Var varA = parser.calc("A=2+5.3");
        Var varB = parser.calc("B="+varA.toString()+"*3.5");
        Var varC = parser.calc("C="+varB.toString()+"("+varA.toString()+"*2)");
        Var varD = parser.calc("D=(("+varC.toString()+"-0.15)-20)/(7-5)");
        Var varE = parser.calc("E={2,3}*("+varD.toString()+"/2)");
        String expected = "{10,15}";
        String actual = varE.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorMultipleScalar() throws Exception {
        Var var = parser.calc("A={3,4}+5*6-7");
        String expected = "{26.0, 27.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void checkVectorSubVector() throws Exception {
        Var var = parser.calc("A={3,4}-{1,2}");
        String actual = var.toString();
        String expected = "{2.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorSubScalar() throws Exception {
        Var var = parser.calc("A={2,3}-1");
        String actual = var.toString();
        String expected = "{1.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkSimpleExpressionMatrix() throws Exception {
        Var var = parser.calc("A={{2, 3},{2, 3}}+{{1, 2},{3, 4}}");
        String expected = "{{3.0, 5.0}, {5.0, 7.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void checkMatrixMulMatrix() throws Exception {
        Var var = parser.calc("A={{1,2},{3,4}}*{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkMatrixSubMatrix() throws Exception {
        Var var = parser.calc("A={{2,3},{4,5}}-{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{1.0, 1.0}, {1.0, 1.0}}";
        assertEquals(expected, actual);
    }
}