package by.it.daletski.jd02_04;

class CalcException extends Exception {

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
