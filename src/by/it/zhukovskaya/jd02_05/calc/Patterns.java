package by.it.zhukovskaya.jd02_05.calc;

class Patterns {

    static final String OPERATION = "(?<=[^(,*+=/-])[-=+*/]";
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    private Patterns() {
    }
}
