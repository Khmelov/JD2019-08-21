package by.it.akhmelev.jd02_04_calc;

interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}
