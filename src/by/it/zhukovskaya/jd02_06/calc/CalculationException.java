package by.it.zhukovskaya.jd02_06.calc;

public class CalculationException extends Exception{

    private static final long serialVersionUID = 8530031785065352301L;

    public CalculationException() {
    }

    public CalculationException(String message) {
        super("ERROR: " + message);
    }

    public CalculationException(Throwable cause) {
        super(cause);
    }

    public CalculationException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalculationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}