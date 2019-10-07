package by.it.agadzhanov.jd02_06_calculator7;

class MatrixCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Matrix(operand);
    }
}
