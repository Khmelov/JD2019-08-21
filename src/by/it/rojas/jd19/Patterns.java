package by.it.rojas.jd19;

public class Patterns {

    //static final String operation = "(?<=[^{,*+=/-])[-=+*/]";
    //static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    //static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    //static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String OPERATION = "(?<=[^{,*+=/-])[-=+*/]";
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{((-?[\\d]+\\.?[\\d]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[\\d]+\\.?[\\d]*),?)+},?)+}";

    private Patterns() {
    }

}
