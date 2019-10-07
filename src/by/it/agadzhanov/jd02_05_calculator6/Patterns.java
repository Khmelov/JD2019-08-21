package by.it.agadzhanov.jd02_05_calculator6;

class Patterns {

    static final String operation = "(?<![-*/+={,])[-+*/=]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+\\}";
    static final String MATRIX = "\\{((\\{((-?[0-9]+\\.?[0-9]*),?)+\\}),?)+\\}";
    static final String PriorityBrackets = "\\([-0-9+*/a-zA-Z.{},_ ]+\\)";

}
