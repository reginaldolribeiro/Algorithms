package exercises.anagram.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AnagramUnicode1 {
    public static void main(String[] args) {
        // Example 1: Basic Latin Characters
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("'" + s1 + "' and '" + t1 + "' is Anagram? " + isAnagram(s1, t1));

    // Example 2: Accented Characters
        String s2 = "résumé";
        String t2 = "ésumér";
//        System.out.println(s2.charAt(s2.length()-1));
//        System.out.println(s2.codePointAt(s2.length()-1));
        System.out.println("'" + s2 + "' and '" + t2 + "' is Anagram? " + isAnagram(s2, t2));

        // Example 3: Symbols and Special Characters
        String s3 = "!@#$%^";
        String t3 = "^%$#@!";
        System.out.println("'" + s3 + "' and '" + t3 + "' is Anagram? " + isAnagram(s3, t3));

        // Example 4: Emojis
        String s4 = "😊🌟💫";
        String t4 = "🌟💫😊";
        System.out.println("'" + s4 + "' and '" + t4 + "' is Anagram? " + isAnagram(s4, t4));

        // Example 5: Mixed Unicode Characters
        String s5 = "𝒶𝓃𝒶𝑔𝓇𝒶𝓂";
        String t5 = "𝓂𝓇𝒶𝓃𝒶𝑔𝒶";
        System.out.println("'" + s5 + "' and '" + t5 + "' is Anagram? " + isAnagram(s5, t5));

        // Example 6: Cyrillic Characters
        String s6 = "анаграм";
        String t6 = "нагарам";
        System.out.println("'" + s6 + "' and '" + t6 + "' is Anagram? " + isAnagram(s6, t6));

        // Example 7: Chinese Characters
        String s7 = "你好世界";
        String t7 = "世界你好";
        System.out.println("'" + s7 + "' and '" + t7 + "' is Anagram? " + isAnagram(s7, t7));

        String s8 = "café";
        String t8 = "face";
        System.out.println("'" + s8 + "' and '" + t8 + "' is Anagram? " + isAnagram(s8, t8));
    }

    /**
     * A single loop handles both incrementing frequencies for characters in s and decrementing frequencies for characters in t.
     * The final loop checks if all frequencies are zero.
     *
     * Big O Notation:
     *  Time Complexity: O(n) – Each character in both strings is processed once, which is the minimum needed.
     *  Space Complexity: O(u) – The Map stores counts for unique characters, where u is the number of unique Unicode characters in the strings.
     *
     * Clarification Questions
     * 1. Will the strings contain only alphabetic letters (a-z, A-Z), or could they include any Unicode characters?
     *      Answer: They can include any Unicode characters (over 143 thousand).
     * 2. Is the comparison case-sensitive, or should it only consider lowercase?
     *      Answer: Comparison should only consider lowercase characters.
     * 3. How should I handle null or empty strings? Should I throw an exception, return false, or handle these differently?
     *      Answer: You should throw an exception for null or empty strings.
     * 4. Should the function return only a boolean result?
     *      Answer: Yes, return only true or false.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t){
        if(s == null || s.isBlank() || t == null || t.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        if(s.length() != t.length())
            return false;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int value1 = s.codePointAt(i);
            frequencies.put(value1, frequencies.getOrDefault(value1, 0) + 1);

            int value2 = t.codePointAt(i);
            frequencies.put(value2, frequencies.getOrDefault(value2, 0) - 1);
        }

        for(Integer value : frequencies.values()){
            if(value != 0)
                return false;
        }

        return true;
    }

}
