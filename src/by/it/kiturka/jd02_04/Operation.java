package by.it.kiturka.jd02_04;

interface Operation {
        Var add(Var other) throws CalcException;

        Var sub(Var other) throws CalcException;

        Var mul(Var other) throws CalcException;

        Var div(Var other) throws CalcException;
}