package by.it.agadzhanov.jd01_011_calculator4;

class Patterns {

    static final String operation = "[-=+/*]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+\\}";
    static final String MATRIX = "\\{((\\{((-?[0-9]+\\.?[0-9]*),?)+\\}),?)+\\}";

}
