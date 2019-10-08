package by.it.zhukovskaya.jd02_06.calc;

class ScalarCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Scalar(operand);
    }
}
