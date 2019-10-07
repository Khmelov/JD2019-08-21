package by.it.shamuradova.calc;

public class Patterns {
    private Patterns(){}
    static final String OPERATION = "(?<=[^{,*+=/-])[-=+*/]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{-?[0-9]+(\\.?[0-9]+)?(,-?[0-9]+\\.?[0-9]*)+}";
    static final String MATRIX = "\\{(\\{-?[0-9]+(\\.?[0-9]+)?(,-?[0-9]+\\.?[0-9]*)+}),(\\{-?[0-9]+(\\.?[0-9]+)?(,-?[0-9]+\\.?[0-9]*)+})+}";

}

/*public class Patterns {

    private Patterns(){}

    static final String OPERATION = "[-+/*]";
    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*}";     //-?[0-9]{1,}\.?[0-9]{0,}  \\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*}
    static final String MATRIX = "\\{"+VECTOR+",("+VECTOR+")*}"; //  \{\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*},(\{-?[0-9]+(\\.[0-9]+)?(,-?[0-9]+(\\.[0-9]+)?)*})*\}

}

 */
