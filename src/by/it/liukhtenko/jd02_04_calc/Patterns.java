package by.it.liukhtenko.jd02_04_calc;

public class Patterns {
    static final String OPERATION = "(?<=[^{,*+=/-])[-=+*/]";
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{((-?[\\d]+\\.?[\\d]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[\\d]+\\.?[\\d]*),?)+},?)+}";

    private Patterns() {
    }
}
