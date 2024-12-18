package exercises.anagram.leetcode;

public class AnagramLetters {
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("'" + s1 + "' and '" + t1 + "' is Anagram? " + isAnagram(s1, t1));

        String s2 = "anagrcam";
        String t2 = "nagaramc";
        System.out.println("'" + s2 + "' and '" + t2 + "' is Anagram? " + isAnagram(s2, t2));

        String s3 = "anagrcam";
        String t3 = "nagaramt";
        System.out.println("'" + s3 + "' and '" + t3 + "' is Anagram? " + isAnagram(s3, t3));
    }

    /**
     * A single loop handles both incrementing frequencies for characters in s and decrementing frequencies for characters in t.
     * The final loop checks if all frequencies are zero.
     *
     * Big O Notation:
     * 	• Time Complexity: O(n), similar to the first implementation, since it also iterates over the strings and frequency array.
     * 	• Space Complexity: O(1), with the same reasoning as the first implementation.
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

        int[] charFrequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isWhitespace(s.charAt(i))) {
                int indexFirstString = s.charAt(i) - 'a';
                charFrequencies[indexFirstString]++;
            }

            if(!Character.isWhitespace(s.charAt(i))) {
                int indexSecondString = t.charAt(i) - 'a';
                charFrequencies[indexSecondString]--;
            }
        }
        for (int charFrequency : charFrequencies) {
            if (charFrequency != 0)
                return false;
        }
        return true;
    }

    /**
     * Two separate loops are used: one to increase the frequencies for characters in s and another to decrease frequencies for characters in t.
     * 	Finally, a third loop checks if all the frequencies are zero.
     *
     * 	Big O Notation:
     * 	• Time Complexity: O(n), where n is the length of the strings. The loops iterate over the strings and frequency array.
     * 	• Space Complexity: O(1) because the charFrequencies array is of fixed size (26 for the alphabet).
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t){
        if(s == null || s.isBlank() || t == null || t.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        if(s.length() != t.length())
            return false;

        int[] charFrequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            int index = value - 'a';
            charFrequencies[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int value = t.charAt(i);
            int index = value - 'a';
            charFrequencies[index]--;
        }

        for (int charFrequency : charFrequencies) {
            if (charFrequency != 0)
                return false;
        }

        return true;
    }
}
