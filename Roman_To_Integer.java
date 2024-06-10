// Solution to Problem Roman To Integer
// Runtime beats ~60% of users and memory ~93%

import java.util.Dictionary;
import java.util.Hashtable;

class Roman_To_Integer {
    static public int romanToInt(String s) {
        Dictionary<Character, Integer> values = new Hashtable<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int previous_value = 0;
        int total_value = 0;
        int value_to_subtract = 0;

        final int string_length = s.length();
        for (int i = string_length - 1; i >= 0; i--) {
            if (values.get(s.charAt(i)) == null) {
                System.out.println("Error: not a roman number: " + s.charAt(i));
                return -1;
            }
            int current_value = values.get(s.charAt(i));
            //System.out.println("Previous value: " + previous_value + ". Current value: " + current_value);
            if (current_value < previous_value) {
                value_to_subtract += current_value;
            } else {
                total_value -= value_to_subtract;
                value_to_subtract = 0;
                total_value += current_value;
            }
            previous_value = current_value;
        }
        total_value -= value_to_subtract;
        return total_value;
    }
}
