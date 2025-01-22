package exercises;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedChar {
    public static void main(String[] args) {
//        String s1 = "abcddefda1111133333333";
//        String s1 = "AA0AB0BB0ccc0aa0aw00wo0BBw123123";
        String s1 = "AA0АB0BB0ccc0aa0aw00wo0BBBw123123";
        char result = mostRepeatedChar(s1);
        System.out.println(result);
    }

    private static char mostRepeatedChar(String s) {
        if (s == null || s.isBlank())
            throw new IllegalArgumentException();

        int maxValue = 0;
        char resultKey = 0;
        int[] frequencies = new int[52]; // 26 uppercase + 26 lowercase
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if((value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z')){
                int index = 0;
                if(Character.isUpperCase(value)){
                    index = value - 'A'; // Uppercase index
                } else {
                    index = value - 'a' + 26; // Lowercase index
                }
                frequencies[index]++;
                if(frequencies[index] > maxValue){
                    maxValue = frequencies[index];
                    resultKey = value;
                }
            }
        }
        return resultKey;
    }

    private static char mostRepeatedChar1(String s) {
        if (s == null || s.isBlank())
            throw new IllegalArgumentException();

        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { // O(n)
            char value = s.charAt(i);
            if((value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z')){
                int count = frequencies.getOrDefault(value, 0) + 1;
                frequencies.put(value, count);
            }
        }

        int maxValue = 0;
        char resultKey = 0;
        for(Map.Entry<Character, Integer> entry : frequencies.entrySet()){ // O(n)
            Integer value = entry.getValue(); // O(1)
            if(value > maxValue) {
                maxValue = value;
                resultKey = entry.getKey(); // O(1)
            }
        }

        return resultKey;
    }

}
