package exercises.leetcode;

/**
 * A class demonstrating the reversal of only letter characters in a string
 * while keeping non-letter characters in their original positions.
 *
 * Example:
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Big O Notation:
 * - Time Complexity: O(n) — The string is traversed once.
 * - Space Complexity: O(n) — The character array requires space proportional to the string length.
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        // Test cases
        String s1 = "ab-cd"; // Expected: "dc-ba"
        String s2 = "a-bC-dEf-ghIj"; // Expected: "j-Ih-gfE-dCba"
        String s3 = "Test1ng-Leet=code-Q!"; // Expected: "Qedo1ct-eeLg=ntse-T!"

        // Print the results of the reverseOnlyLetters method
        System.out.println("String: " + s1 + " -> Reversed: " + reverseOnlyLetters(s1));
        System.out.println("String: " + s2 + " -> Reversed: " + reverseOnlyLetters(s2));
        System.out.println("String: " + s3 + " -> Reversed: " + reverseOnlyLetters(s3));
    }

    /**
     * Reverses only the letters in the string, keeping non-letter characters in their
     * original positions.
     *
     * Algorithm:
     * 1. Use two pointers (`start` and `end`) to traverse the string from both ends.
     * 2. Check if characters at the pointers are letters:
     *    - If the `start` pointer is not a letter, move it forward.
     *    - If the `end` pointer is not a letter, move it backward.
     *    - If both are letters, swap them and move both pointers inward.
     * 3. Repeat until the `start` and `end` pointers meet or cross.
     *
     * Edge Cases:
     * - Null or empty strings are returned as is.
     * - Strings with no letters remain unchanged.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each character is processed at most once.
     * - Space Complexity: O(n) — A new character array is created for the result.
     *
     * @param s The input string to process.
     * @return A new string with only the letters reversed.
     */
    private static String reverseOnlyLetters(String s) {
        // Handle edge cases: null or empty strings
        if(s == null || s.length() <= 1)
            return s;

        // Initialize pointers and convert the string to a character array
        int start = 0;
        int end = s.length() - 1;
        char[] result = s.toCharArray();

        // Process the string using two pointers
        while (start <= end) {
            char first = s.charAt(start);
            char last = s.charAt(end);

            // If the start character is not a letter, move the start pointer forward
            if (!Character.isLetter(first)) {
                start++;
            }
            // If the end character is not a letter, move the end pointer backward
            else if (!Character.isLetter(last)) {
                end--;
            }
            // If both characters are letters, swap them and move both pointers
            else {
                result[start] = last;
                result[end] = first;
                start++;
                end--;
            }
        }

        // Return the result as a new string
        return new String(result);
    }

}
