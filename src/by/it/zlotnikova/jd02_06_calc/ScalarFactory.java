package by.it.zlotnikova.jd02_06_calc;

public class ScalarFactory implements VarFactory {
    @Override
    public Var createVar(String strVar) {
        Var result = new Scalar(Double.parseDouble(strVar));
        return result;
    }
}
