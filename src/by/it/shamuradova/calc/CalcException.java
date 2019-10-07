package by.it.shamuradova.calc;

public class CalcException extends Exception {

    CalcException() {
    }

    CalcException(String message) {
        super("ERROR: " + message);
    }

    CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }
}

