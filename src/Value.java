import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import exception.CalculationException;

public class Value {
    private final int value;
    private final Map<String, Integer> romanMap = new HashMap<>();
    private static final TreeMap<Integer, String> arabMap = new TreeMap<>();
    private final boolean isRoman;

    {
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);

        arabMap.put(1000, "M");
        arabMap.put(900, "CM");
        arabMap.put(500, "D");
        arabMap.put(400, "CD");
        arabMap.put(100, "C");
        arabMap.put(90, "XC");
        arabMap.put(50, "L");
        arabMap.put(40, "XL");
        arabMap.put(10, "X");
        arabMap.put(9, "IX");
        arabMap.put(5, "V");
        arabMap.put(4, "IV");
        arabMap.put(1, "I");

    }

    public Value(String valueStr) {
        try {

            if (isRoman(valueStr)) {
                this.value = toArab(valueStr);
                this.isRoman = true;
            } else {
                this.value = Integer.parseInt(valueStr);
                this.isRoman = false;
            }
        } catch (NullPointerException e) {
            throw new CalculationException(e);
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isRoman() {
        return isRoman;
    }

    private boolean isRoman(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private Integer toArab(String s) {
        s = s.toUpperCase();
        int[] arabArray = new int[s.length()];
        char[] romanArray = s.toCharArray();
        int arab = 0;

        for (int i = 0; i < s.length(); i++) {              //translate to arab array
             arabArray[i] = romanMap.get(String.valueOf(romanArray[i]));
        }

        if (arabArray.length == 1) {
            return arabArray[0];
        }

        for (int i = 0; i < arabArray.length; i++) {        //get arab value
            if (i == arabArray.length - 1) {
                arab += arabArray[i];
            } else if ((arabArray[i] < arabArray[i + 1])) {
                arab += arabArray[i + 1] - arabArray[i];
                i++;
            } else {
                arab += arabArray[i];
            }
        }

        return arab;
    }

    public static String toRoman(Integer number) {
        int l =  arabMap.floorKey(number);
        if ( number == l ) {
            return arabMap.get(number);
        }
        return arabMap.get(l) + toRoman(number-l);
    }
}
