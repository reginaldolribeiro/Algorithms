package exercises.leetcode;

/**
 * A class demonstrating how to reverse a character array in place.
 *
 * Example:
 * Input: ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 *
 * This solution uses the two-pointer technique for efficient in-place reversal.
 */
public class ReverseString {

    public static void main(String[] args) {
        // Example test cases
        char[] s1 = {'h', 'e', 'l', 'l', 'o'}; // Expected output: ['o', 'l', 'l', 'e', 'h']
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'}; // Expected output: ['h', 'a', 'n', 'n', 'a', 'H']
        char[] s3 = {}; // Edge case: empty array (no change)

        // Reverse and print the results
        reverseString(s1);
        System.out.println(s1);

        reverseString(s2);
        System.out.println(s2);

        reverseString(s3);
        System.out.println(s3);
    }

    /**
     * Reverses a character array in place using the two-pointer technique.
     *
     * Algorithm:
     * 1. Use two pointers (`start` and `end`) to traverse the array from both ends.
     * 2. Swap the characters at the `start` and `end` indices.
     * 3. Move the pointers closer together until they meet or cross.
     * 4. If the array is null or has only one character, do nothing.
     *
     * Big O Notation:
     * - Time Complexity: O(n), where "n" is the length of the array (each element is processed once).
     * - Space Complexity: O(1), because the reversal is done in place without extra storage.
     *
     * @param s The character array to reverse.
     */
    private static void reverseString(char[] s) {
        // Handle edge cases: null or single-character arrays
        if (s == null || s.length <= 1) {
            return;
        }

        // Initialize two pointers
        int start = 0;
        int end = s.length - 1;

        // Swap characters at the start and end pointers until they meet
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}