package by.it.agadzhanov.jd02_06_calculator7;

class ScalarCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Scalar(operand);
    }
}
