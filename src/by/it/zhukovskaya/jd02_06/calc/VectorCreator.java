package by.it.zhukovskaya.jd02_06.calc;

class VectorCreator implements VarCreator {

    @Override
    public Var getVar(String operand) {
        return new Vector(operand);
    }
}