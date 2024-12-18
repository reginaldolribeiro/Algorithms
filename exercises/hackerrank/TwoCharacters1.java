package exercises.hackerrank;

import java.util.*;

public class TwoCharacters1 {
    public static void main(String[] args) {
        String s = "abaacdabd";
//        String s = "abacacdebd";
//        String s = "beabeefeab";
//        String s = "asvkugfiugsalddlasguifgukvsa";
        int result = alternate(s);
        System.out.println("Alternate " + result);
    }

    // abaacdabd
    private static int alternate(String s){
        if(s == null || s.isBlank()) return 0;

        // convert to Set in order to get only unique chars
        Set<Character> uniqueChars = new HashSet<>();
        for(char c : s.toCharArray()){
            uniqueChars.add(c);
        }

        // iterate through the Set to get all the possible pairs of chars
        // Outer loop + Inner loop
        int maxLength = 0;
        List<Character> uniqueList = new ArrayList<>(uniqueChars);

        for (int i = 0; i < uniqueList.size(); i++) {
            for (int j = i+1; j < uniqueList.size(); j++) {
                char currentValue = uniqueList.get(i);
                char nextValue = uniqueList.get(j);

                // Iterate through the String checking IF the current char is in the pair
                // IF is it should count. We need to check for alternating strings
                // Return count of strings
                int length = getLength(s, currentValue, nextValue);

                // Check what's the greater count of strings
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    private static int getLength(String s, char currentValue, char nextValue) {
        int length = 0;
        char lastChar = 0;
        for(char c : s.toCharArray()){
            if(c == lastChar)
                return 0;
            if(c == currentValue || c == nextValue){
                length++;
                lastChar = c;
            }
        }
        return length;
    }

}
