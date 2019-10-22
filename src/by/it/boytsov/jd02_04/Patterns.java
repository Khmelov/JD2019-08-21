package by.it.boytsov.jd02_04;

public class Patterns {

    static final String OPERATION="[-+/*]";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String PRIORITY = "\\([-0-9+*/a-zA-Z.{},_ ]+\\)";
}
