package exception;

public class CalculationException extends RuntimeException{

    public CalculationException(RuntimeException e) {
        super(e);
    }

    public CalculationException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Некоректное выражение";
    }
}
