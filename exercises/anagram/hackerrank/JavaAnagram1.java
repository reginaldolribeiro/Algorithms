package exercises.anagram.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaAnagram1 {

    public static void main(String[] args) {
        String a = "anagram";
        String b = "margana";

        String a1 = "anAgram";
        String b1 = "margana";

        String a2 = "anAgram";
        String b2 = "margAna";

        String a3 = "aaabbb";
        String b3 = "bbaaa";

        System.out.println( (isAnagram(a, b)) ? "Anagrams" : "Not Anagrams" );
        System.out.println( (isAnagram(a1, b1)) ? "Anagrams" : "Not Anagrams" );
        System.out.println( (isAnagram(a2, b2)) ? "Anagrams" : "Not Anagrams" );
        System.out.println( (isAnagram(a3, b3)) ? "Anagrams" : "Not Anagrams" );
    }

    private static boolean isAnagram(String a, String b) {
        if(a == null || a.isBlank() || b == null || b.isBlank())
            throw new IllegalArgumentException("String must be not null and not empty.");

        if(a.length() != b.length())
            return false;

        int[] charFrequencies = new int[128];

        for (int i = 0; i < a.length(); i++) {
            int indexA = a.charAt(i);
            charFrequencies[indexA]++;

            int indexB = b.charAt(i);
            charFrequencies[indexB]--;
        }

        // Check if there is any
        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] != 0)
                return false;
        }

        return true;
    }

    /**
     * Most efficient
     *
     * Big O Notation
     *  Time complexity: O(n)
     *  Space complexity: O(1), because the space used by the charFrequencies array is constant, O(26) which simplifies to O(1).
     *
     * 1. Create an int array with 26 size (26 letters in alphabet) and every position it has a value of 0 (zero)
     * 2. Iterate through A string adding +1 for each string
     * 3. Iterate through B string decreasing -1 for each string
     * 4. At the end we iterate through our int array checking if it has different value of 0 (zero) for any letter
     *     of string A and B, and if it is means that are Not Anagrams, otherwise is Anagram
     *
     * a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
     *
     * @param a
     * @param b
     * @return
     */
//    private static boolean isAnagram(String a, String b) {
//        if(a.length() != b.length()) return false;
//
//        a = a.toLowerCase(); // O(n)
//        b = b.toLowerCase(); // O(n)
//
//        // array of size 26 (assuming only lowercase English letters) to count character frequencies
//        int[] charFrequencies = new int[26];
//
//        // Increment counts for string a
//        for(char c : a.toCharArray()){ // O(n)
//            int index = c - 'a';
//            charFrequencies[index]++; // O(1)
//        }
//
//        // Decrement counts for string b
//        for(char c : b.toCharArray()){ // O(n)
//            int index = c - 'a';
//            charFrequencies[index]--; // O(1)
//        }
//
//        // Check if there is any
//        for (int i = 0; i < charFrequencies.length; i++) {
//            if(charFrequencies[i] != 0) return false;
//        }
//
//        return true;
//    }


    // 2. Armazenar a contagem dos caracteres em um Map para cada String e comparar se sao iguais

    /**
     * Create maps to count the frequency of each character in both string
     * Populates these maps
     * Compare the two frequency maps
     *
     * Big O Notation
     *  Time Complexity: O(n)
     *  Space Complexity: O(1) (considering a fixed character set, otherwise O(n))
     *
     * 	Time Complexity: O(n)
     * 	•	Converting the strings to lowercase: O(n) for each string.
     * 	•	Populating the frequency maps: O(n) for each string.
     * 	•	Comparing the maps: O(n).
     *
     * 	Space Complexity: O(1) (considering a fixed character set, otherwise O(n))
     * 	•	The space used by the frequency maps is proportional to the number of unique characters in the strings.
     * 	    For a fixed character set (like all lowercase English letters), this space is constant.
     * 	    If the character set is not fixed, the space complexity would be O(n).
     *
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean isAnagram2(String a, String b) {
        if(a.length() != b.length()) return false;

        Map<Character, Integer> charCountA = new HashMap<>();
        Map<Character, Integer> charCountB = new HashMap<>();

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (Character c : a.toCharArray()){
            charCountA.put(c, charCountA.getOrDefault(c, 0)+1);
        }
        for (Character c1 : b.toCharArray()){
            charCountB.put(c1, charCountB.getOrDefault(c1, 0)+1);
        }

        return charCountA.equals(charCountB);
    }

    // 2. Armazenar a contagem dos caracteres em um Map para cada String e comparar se sao iguais
    private static boolean isAnagram3(String a, String b) {
        if(a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<String, Integer> mapA = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            String value = String.valueOf(a.charAt(i));
            if(mapA.containsKey(value)){
                mapA.put(value, mapA.get(value)+1);
            } else {
                mapA.put(value, 1);
            }
        }

        Map<String, Integer> mapB = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            String value = String.valueOf(b.charAt(i));
            if(mapB.containsKey(value)){
                mapB.put(value, mapB.get(value)+1);
            } else {
                mapB.put(value, 1);
            }
        }

        return mapA.equals(mapB);
    }

    /**
     * Sort an array of string and compare if are equal
     *
     * Big O Notation
     *  Time Complexity: O(n log n)
     *  Space Complexity: O(n)
     *
     * Time Complexity:
     *
     * 	•	Converting strings to lowercase: O(n) for each string, where n is the length of the strings.
     * 	•	Converting strings to character arrays: O(n) for each string.
     * 	•	Sorting the character arrays: O(n log n) for each array.
     * 	•	Comparing the sorted arrays: O(n).
     *
     * Overall, the time complexity is dominated by the sorting step, resulting in O(n log n).
     *
     * Space Complexity:
     *
     * 	•	Space for character arrays: O(n) for each string.
     * 	•	Space for sorting: O(log n) for the sorting algorithm.
     *
     * Overall, the space complexity is O(n) due to the space required for the character arrays.
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean isAnagram4(String a, String b) {
        if(a.length() != b.length()) return false;

        a = a.toLowerCase();  // O(n)
        b = b.toLowerCase();  // O(n)

        char[] aCharArray = a.toCharArray(); // O(n)
        Arrays.sort(aCharArray); // O(n)

        char[] bCharArray = b.toCharArray(); // O(n)
        Arrays.sort(bCharArray); // O(n)

        return Arrays.equals(aCharArray, bCharArray); // O(n)
    }

}
