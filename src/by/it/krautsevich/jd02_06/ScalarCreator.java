package by.it.krautsevich.jd02_06;

class ScalarCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Scalar(operand) ;
    }
}
