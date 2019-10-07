package by.it.zlotnikova.jd02_04_calc;

class Patterns {

    static final String OPERATION = "(?<=[^{,*+=/-])[-+*/=]";
    static final String SCALAR = "-?[0-9]+(\\.?[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

}
