import exception.CalculationException;

public class Calculation {
    public static int calculation(String sign, Value value1, Value value2) throws CalculationException {
        if (value1.isRoman() != value2.isRoman()) {
            throw new CalculationException();
        }

        switch (sign) {
            case "+": return value1.getValue() + value2.getValue();
            case "-": return value1.getValue() - value2.getValue();
            case "*": return value1.getValue() * value2.getValue();
            case "/": {
                if (value1.getValue() % value2.getValue() == 0){
                    return value1.getValue() / value2.getValue();
                }else {
                    throw new CalculationException();
                }
            }
            default: throw new ClassCastException();
        }
    }
}
