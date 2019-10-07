package by.it.yuntsevich.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(ResourceManager.INSTANCE.get(Messages.ERROR) +message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResourceManager.INSTANCE.get(Messages.ERROR) +message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ResourceManager.INSTANCE.get(Messages.ERROR) +message, cause, enableSuppression, writableStackTrace);
    }
}
