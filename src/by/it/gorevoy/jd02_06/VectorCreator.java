package by.it.gorevoy.jd02_06;

class VectorCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Vector(operand);
    }
}