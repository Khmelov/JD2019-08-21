package by.it.krautsevich.jd02_06;

class CalcException extends Exception {

    CalcException() {
    }

    CalcException(String message) {
        super("ERROR: " + message);
        Logger.getLogger().log(message);

    }

    CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }
}
