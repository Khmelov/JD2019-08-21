package by.it.rubatskii.jd02_06;

class MatrixCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Matrix(operand);
    }
}