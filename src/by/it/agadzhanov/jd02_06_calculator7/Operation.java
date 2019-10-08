package by.it.agadzhanov.jd02_06_calculator7;

interface Operation {

    Var add(Var other) throws CalculationException;

    Var sub(Var other) throws CalculationException;

    Var mul(Var other) throws CalculationException;

    Var div(Var other) throws CalculationException;

}