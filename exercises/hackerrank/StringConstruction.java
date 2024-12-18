package exercises.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class StringConstruction {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abab";
        String s3 = "abcabd";
        String s4 = "abcabde";
        String s5 = "aaaa";
        String s6 = "xyz";
        String s7 = "abcabc";
        String s8 = "abcabcabc";
        String s9 = "abacabad";
        System.out.println("Min cost " + stringConstruction(s1));
        System.out.println("Min cost " + stringConstruction(s2));
        System.out.println("Min cost " + stringConstruction(s3));
        System.out.println("Min cost " + stringConstruction(s4));
        System.out.println("Min cost " + stringConstruction(s5));
        System.out.println("Min cost " + stringConstruction(s6));
        System.out.println("Min cost " + stringConstruction(s7));
        System.out.println("Min cost " + stringConstruction(s8));
        System.out.println("Min cost " + stringConstruction(s9));
    }

        /**
         * Most efficient approach
         *
         * Considering the string have only lowercase letters, we can initialize an array of alphabet and
         * count all items is greater than one.
         *
         * Big O Notation
         *  Time Complexity: O(n), where n is the length of the string. The first loop runs through the string once, and the second loop runs through the fixed-size array of size 26.
         *  Space Complexity: O(1). The space used by the charFrequencies array is constant, as its size is fixed (26 elements), regardless of the input size.
         *
         * @param s
         * @return cost
         */
        public static int stringConstruction(String s) {
            if (s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
            if (s.length() == 1) return 1;

            boolean[] charFrequencies = new boolean[26];
            for (int i = 0; i < s.length(); i++) {
                char value = s.charAt(i);
                int index = value - 'a';
                charFrequencies[index] = true;
            }

            int cost = 0;
            for (boolean charFrequency : charFrequencies)
                if (charFrequency)
                    cost++;

            return cost;
        }

        /**
         * Most efficient approach
         *
         * Calculates cost of copying to a newString.
         *
         * Big O Notation
         *  Time: O(n)
         *  Space: O(n) due to the space required for storing the characters in the Set.
         *
         * @param s
         * @return cost
         */
        public static int stringConstructionCharFreq(String s) {
            if (s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
            if (s.length() == 1) return 1;

            int[] charFrequencies = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char value = s.charAt(i);
                int index = value - 'a';
                charFrequencies[index]++;
            }

            int cost = 0;
            for (int charFrequency : charFrequencies)
                if (charFrequency > 0)
                    cost++;

            return cost;
        }

    /**
     * Most straightforward approach
     *
     * Calculates cost of copying to a newString.
     *
     * Big O Notation
     *  Time: O(n)
     *  Space: O(n) due to the space required for storing the characters in the Set.
     *
     * @param s
     * @return cost
     */
    public static int stringConstructionSet(String s) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
        if(s.length() == 1) return 1;

        Set<Character> uniqueChars = new HashSet<>();
        for (Character c : s.toCharArray()){
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    /**
     * Calculates cost of copying to a newString and print the newString.
     *
     * Big O Notation
     *  Time: O(n) because you are iterating over the string once, and each character operation (check and add) with the Set is O(1) on average.
     *  Space: O(n) due to the space required for storing the characters in the Set and for the StringBuilder.
     *
     * @param s
     * @return
     */
    public static int stringConstructionPrintString(String s) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
        if(s.length() == 1) return 1;

        Set<Character> lastChars = new HashSet<>();
        StringBuilder newString = new StringBuilder();
        int cost = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);
            if (!lastChars.contains(currentValue)) {
                lastChars.add(currentValue);
                newString.append(currentValue);
                cost++;
            } else {
                newString.append(currentValue);
            }
        }
        System.out.println("New String " + newString);

        return cost;
    }

    /**
     * More complex approach
     *
     * @param s
     * @return cost
     */
    public static int stringConstructionPrintString1(String s) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
        if(s.length() == 1) return 1;

        StringBuilder newString = new StringBuilder();
        int initial = 0;
        int cost = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);

            if(newString.isEmpty()){
                newString.append(currentValue);
                cost++;
            }else{
                boolean containsChar = newString.indexOf(String.valueOf(s.charAt(i))) != -1;
                if(containsChar){
                    if(initial == 0)
                        initial = i;
                    if(i+1 == s.length()) {
                        String substring = s.substring(initial, i+1);
                        newString.append(substring);
                    }
                }else{
                    if(initial == 0) {
                        newString.append(currentValue);
                        cost++;
                    } else {
                        if(i > initial){
                            String substring = s.substring(initial, i);
                            newString.append(substring).append(currentValue);
                            cost++;
                            initial = 0;
                            // nao tem custo
                        }else{
                            newString.append(currentValue);
                            cost++;
                        }
                    }
                }
            }
        }

        System.out.println("New String " + newString);
        return cost;
    }

    public static int stringConstructionPrintString2(String s) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
        if(s.length() == 1) return 1;

        String newString = null;
        int initial = 0;
        int cost = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentValue = s.charAt(i);
            if(newString == null){
                newString = String.valueOf(currentValue);
                cost++;
            }else{
                if(newString.contains(String.valueOf(currentValue))){
                    if(initial == 0)
                        initial = i;
                    if(i+1 == s.length()) {
                        String substring = s.substring(initial, i+1);
                        newString = newString + substring;
                    }
                }else{
                    if(initial == 0) {
                        newString = newString + currentValue;
                        cost++;
                    } else {
                        if(i > initial){
                            String substring = s.substring(initial, i);
                            newString = newString + substring + currentValue;
                            cost++;
                            initial = 0;
                            // nao tem custo
                        }else{
                            newString = "" + currentValue;
                            cost++;
                        }
                    }
                }
            }
        }

        System.out.println("New String " + newString);
        return cost;
    }

}
