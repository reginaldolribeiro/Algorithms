package exercises.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "abba";
//        String s = "abcde";
//        String s = "dvdf";
//        String s = " ";
        int result = longestSubstring(s);
        System.out.println(result);
    }

    /**
     * Big O Notation
     * - Time Complexity: O(n)
     * - Space Complexity: O(1) (since array size is fixed)
     *
     * @param s
     * @return
     */
    public static int longestSubstring(String s){
        if(s == null)
            throw new IllegalArgumentException("String must not be null.");

        // Initialize an array to store the last index of each ASCII character
        // Size 128 covers all standard ASCII characters
        int[] arr = new int[128];
        // Fill the array with -1 to indicate that no characters have been seen yet
        Arrays.fill(arr, -1);

        int start = 0, total = 0, maximum = 0;
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);      // Current character
            int ascii = (int) value;       // ASCII value of the current character

            // If the character has been seen before and is within the current window
            if(arr[ascii] > -1){
                System.out.println("Value: " + value + " " + "arr[" + ascii + "] maior que -1. Valor: " + arr[ascii]);
                // Move the start pointer to the right of the previous occurrence
                start = Math.max(start, arr[ascii] + 1);
            }

            // Update the last seen index of the current character
            arr[ascii] = i;

            // Calculate the length of the current substring
            total = i - start + 1;

            // Update the maximum length if the current substring is longer
            maximum = Math.max(maximum, total);
        }
        return maximum;
    }

    /**
     *
     * Big O Notation:
     * 	Time Complexity:
     * 	Space Complexity:
     *
     * @param s
     * @return
     */
    // "abcabcbb"
    public static int longestSubstring1(String s){
        if(s == null)
            throw new IllegalArgumentException("String must not be null.");

        int start = 0, maximum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            Integer mapValue = map.get(value);
            if(mapValue != null){
                start = Math.max(start, mapValue+1);
            }
            map.put(value, i);
            int total = i - start + 1;
            maximum = Math.max(maximum, total);
        }
        return maximum;
    }




//    public static int longestSubstring(String s){
//        if(s == null)
//            throw new IllegalArgumentException("String must not be null.");
//        if(s.isBlank())
//            return 0;
//
//        int start = 0, end = 0, maximum = 0;
//        int[] frequencies = new int[128];
//        for (int i = 0; i < s.length(); i++) {
//            char value = s.charAt(i);
//            int index = value - 'a';
//            if(frequencies[index] > 0){
//                int total = (end - index);
//                if(total > maximum)
//                    maximum = total;
//            } else{
//                frequencies[index] = i;
//                end++;
//            }
//        }
//
//        return maximum;
//    }

    /**
     * Use sliding window with two-pointer technique.
     *
     * It works but complex reseting hashmap
     *
     *
     * Big O Notation:
     * 	Time Complexity:
     * 	Space Complexity:
     *
     * @param s
     * @return
     */
    // "abcabcbb"
//    public static int longestSubstring(String s){
//        if(s == null)
//            throw new IllegalArgumentException("String must not be null.");
//        if(s.isBlank())
//            return 0;
//
//        int start = 0, maximum = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char value = s.charAt(i);
//            if(map.containsKey(value)){
//                start = Math.max(start, map.get(value) + 1);
//            }
//            map.put(value, i);
//            maximum = Math.max(maximum, i - start + 1);
//        }
//
//        return maximum;
//    }

    /**
     * Big O Notation:
     * 	Time Complexity: O(n²)
     * 	    In the worst case, for each character, it may iterate through the entire map of previously seen characters, leading to a quadratic time complexity.
     * 	Space Complexity: O(n)
     * 	    The map stores up to n unique characters in the worst case.
     *
     * @param s
     * @return
     */
    public static int longestSubstringWorks(String s){
        if(s == null)
            throw new IllegalArgumentException("String must not be null.");
        if(s.isBlank())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maximum = 0;
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            Integer mapValue = map.get(value);
            if(mapValue != null){
                int total = 0;
                for(Integer value1 : map.values()){
                    total += value1;
                }
                if(total > maximum){
                    maximum = total;
                }
                map = new HashMap<>();
                map.put(value, 1);
            } else {
                map.put(value, 1);
            }
        }

        return maximum;
    }
}
