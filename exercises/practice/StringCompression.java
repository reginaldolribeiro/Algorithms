package exercises.practice;

/**
 * A class demonstrating string compression by counting consecutive characters
 * and limiting the count to 9 for each group.
 *
 * Example:
 * Input: "bbbbbbbbbbbaabbc"
 * Output: "9b2b2a2b1c"
 */
public class StringCompression {

    public static void main(String[] args) {
        // Example test cases
        String message1 = "aeiou"; // Expected output: "1a1e1i1o1u"
        String message2 = "bbbbbbbbbbbaabbc"; // Expected output: "9b2b2a2b1c"

        // Print the results of string compression
        System.out.println("Compressed message1: " + stringCompression(message1));
        System.out.println("Compressed message2: " + stringCompression(message2));
    }

    /**
     * Compresses a string by counting consecutive characters and appending
     * the count followed by the character to the result. Limits the count to 9
     * for each group of consecutive characters.
     *
     * Example:
     * Input: "bbbbbbbbbbbaabbc"
     * Output: "9b2b2a2b1c"
     *
     * Algorithm:
     * 1. Use an external `while` loop to iterate through the string.
     * 2. Use an internal `while` loop to count consecutive equal characters (up to 9).
     * 3. Append the count and character to a `StringBuilder`.
     * 4. Move the index forward as characters are processed.
     *
     * Big O Notation:
     * - Time Complexity: O(n), where "n" is the length of the string (each character is processed exactly once).
     * - Space Complexity: O(n), because the `StringBuilder` requires space proportional to the length of the compressed result.
     *
     * @param word The input string to compress.
     * @return The compressed string.
     */
    private static String stringCompression(String word) {
        int i = 0; // Index to traverse the string
        StringBuilder result = new StringBuilder(); // To construct the compressed result

        // Process the string until all characters are covered
        while (i < word.length()) {
            char letter = word.charAt(i); // Current character
            int count = 0; // Count of consecutive occurrences of the character

            // Count consecutive characters up to 9
            while (i < word.length() && count < 9 && letter == word.charAt(i)) {
                i++;
                count++;
            }

            // Append the count and the character to the result
            result.append(count).append(letter);
        }

        return result.toString(); // Return the compressed string
    }
}