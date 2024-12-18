package exercises.hackerrank;

public class AlternatingCharacters {
    public static void main(String[] args) {
        String s1 = "aabaab"; // 2 deletions
        String s2 = "aaaa"; // 3 deletions
        String s3 = "bbbbb"; // 4 deletions
        String s4 = "abababab"; // 0 deletions
        String s5 = "bababa"; // 0 deletions
        String s6 = "aaabbb"; // 4 deletions
        System.out.println("Deletions " + alternatingCharacters(s1));
        System.out.println("Deletions " + alternatingCharacters(s2));
        System.out.println("Deletions " + alternatingCharacters(s3));
        System.out.println("Deletions " + alternatingCharacters(s4));
        System.out.println("Deletions " + alternatingCharacters(s5));
        System.out.println("Deletions " + alternatingCharacters(s6));
    }

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * Iterates through the string, comparing each character with the previous one.
     * If two adjacent characters are the same, it increments a counter (deletions).
     * The method returns this counter as the number of deletions required.
     *
     * Checks:
     *  1. Check string is null, empty or blank
     *  2. Check If the string it has just One char, return 0 (zero)
     * The string only have character A and B inside the string
     *
     * Examples:
     *  String s = "aaaa"
     *  ----> deletions = 3
     *
     *  String s = "aabaab"
     *  ----> deletions = 2
     *
     *  String s = "abababab"
     *  ----> deletions = 0
     *
     * @param s
     * @return
     */
    public static int alternatingCharacters(String s) {
        // Check if the input string is null or blank and throw an exception if it is
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        // If the string has only one character, no deletions are needed
        if(s.length() == 1)
            return 0;

        int deletions = 0;

        // Iterate through the string starting from the second character
        // If the current character is the same as the previous one, increment the deletion counter
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) ==  s.charAt(i-1)){
                deletions++;
            }
        }
        return deletions;
    }

}
