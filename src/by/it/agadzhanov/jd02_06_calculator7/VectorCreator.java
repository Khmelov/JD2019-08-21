package by.it.agadzhanov.jd02_06_calculator7;

class VectorCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Vector(operand);
    }
}
