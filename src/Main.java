import java.util.Scanner;
import exception.CalculationException;

public class Main {
    public static void main(String[] args) {
        String values[];
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        values = str.split("[-+/*]"); // Разделение на первое-второе слогаемые

        if (values.length != 2) {   //Проверка, что у нас только 2 слогаемых
            throw new CalculationException();
        }

        String sign = str.replaceAll("[^-+/*]","");   // Получение знака

        Value value1 = new Value(values[0]);
        Value value2 = new Value(values[1]);
        int result = Calculation.calculation(sign, value1, value2);

        if (value1.isRoman()) {  //Перевод в римские, если изначально были римские
            System.out.println("Result: " + Value.toRoman(result));
        } else {
            System.out.println("Result: " + result);
        }

    }
}
