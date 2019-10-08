package by.it.zhukovskaya.jd02_06.calc;

interface Operation {

    Var add(Var other) throws CalculationException;

    Var sub(Var other) throws CalculationException;

    Var mul(Var other) throws CalculationException;

    Var div(Var other) throws CalculationException;

}
