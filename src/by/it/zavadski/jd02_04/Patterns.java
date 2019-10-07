package by.it.zavadski.jd02_04;

public final class Patterns {
    static final String OPERATION="(?<=[^{,*+=/-])[-=+/*]";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="[{]((-?\\d+(\\.\\d+)?),?\\s?)+[}]";
    static final String MATRIX="\\{\" + VECTOR + \",\\s?\" + VECTOR + \"\\}";
    static final String BRACKETS="\\(.*\\)";

    private Patterns(){};
}
