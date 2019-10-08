package by.it.zhukovskaya.jd02_06.calc;

class MatrixCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Matrix(operand);
    }
}
