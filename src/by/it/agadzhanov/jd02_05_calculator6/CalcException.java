package by.it.agadzhanov.jd02_05_calculator6;

public class CalcException extends Exception{

    private static final long serialVersionUID = 8530031785065352301L;

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}
