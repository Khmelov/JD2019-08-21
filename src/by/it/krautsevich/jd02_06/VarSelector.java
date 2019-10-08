package by.it.krautsevich.jd02_06;

class VarSelector {

    static VarCreator selectCreator(String operand) throws CalcException {
        operand = operand.trim().replace(" " , "");
        if (operand.matches(Patterns.SCALAR))
        return new ScalarCreator();
        else if (operand.matches(Patterns.VECTOR))
        return new VectorCreator();
        else return null ;

    }
}
