package by.it.shamuradova.calc3;

interface Operation {
    Var add(Var other)throws CalcException;
    Var sub(Var other)throws CalcException;
    Var mul(Var other)throws CalcException;
    Var div(Var other)throws CalcException;
}