package by.it.akhmelev.jd02_04_calc;

final class Patterns {

    static final String OPERATION = "(?<=[^{,*+=/-])[-=+*/]";
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    private Patterns() {
    }
}
