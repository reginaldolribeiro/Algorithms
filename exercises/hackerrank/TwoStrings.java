package exercises.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
    public static void main(String[] args) {
//        String s1 = "and";
//        String s2 = "art";
        String s1 = "be";
        String s2 = "cat";
        System.out.println(twoStrings(s1,s2));
    }

    /**
     * MOST efficient
     *
     * Big O Notation:
     *  Time Complexity: O(n + m), where n is the length of s1 and m is the length of s2
     * 	Space Complexity: O(1) because the array size is constant (26 elements for lowercase English letters)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String twoStrings(String s1, String s2) {
        if(s1 == null || s1.isBlank()) throw new IllegalArgumentException("Must be a valid String");
        if(s2 == null || s2.isBlank()) throw new IllegalArgumentException("Must be a valid String");

        int[] charFrequencies = new int[26];
        for(Character c : s1.toCharArray()){
            int index = c - 'a';
            charFrequencies[index]++;
        }
        for(Character c : s2.toCharArray()){
            int index = c - 'a';
            if(charFrequencies[index] > 0){
                return "YES";
            }
        }
        return "NO";
    }

    public static String twoStrings2(String s1, String s2) {
        if(s1 == null || s1.isBlank()) throw new IllegalArgumentException("Must be a valid String");
        if(s2 == null || s2.isBlank()) throw new IllegalArgumentException("Must be a valid String");

        int[] charFrequencies = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            int index = value - 'a';
            charFrequencies[index]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            int index = value - 'a';
            if(charFrequencies[index] > 0){
                return "YES";
            }
        }
        return "NO";
    }

    /**
     * 	Big O Notation:
     * 	    Time Complexity: O(n + m)
     * 	    Space Complexity: O(n), where n is the length of s2
     *
     * 	Set.contains() is O(1)
     * 	Array.contains() is O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String twoStrings1(String s1, String s2) {
        if(s1 == null || s1.isBlank()) throw new IllegalArgumentException("Must be a valid String");
        if(s2 == null || s2.isBlank()) throw new IllegalArgumentException("Must be a valid String");

        Set<Character> charInS2 = new HashSet<>();
        for(char c : s2.toCharArray()){
            charInS2.add(c);
        }

        boolean result = false;
        for(Character c : s1.toCharArray()){ // O(n)
            if(charInS2.contains(c)){ // O(n)
                return "YES";
            }
        }

        return "NO";
    }

}
