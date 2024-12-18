package exercises.anagram.hackerrank;

public class AnagramLetters {
    public static void main(String[] args) {
        String s = "aabcccde";
//        String s = "aaaabbbb";
        int changes = anagram(s);
        System.out.println("Changes: " + changes);
    }


    /**
     * Clarification Questions
     * 1. Will the string only contain alphabetic letters (a-z, A-Z), or could it include other characters?
     *      Yes!
     * 2. Is the comparison case-sensitive (e.g., 'A' vs. 'a')?
     *      No!
     * 3. How should I handle null or empty strings? Should I throw an exception, return 0, or ignore these cases?
     *      throw an exception
     * 4. Will the length of the string always be even, allowing it to be split into two equal halves?
     *      Yes!
     * 5. If the string length is odd, does that automatically mean they can't be anagrams, or should I return a specific result like 0 or throw an error?
     *      Return 0
     * 6. Should I only return the number of changes needed to make these substrings anagrams, or do I need to track which specific characters were changed?
     *      You should only return the number of changes
     * 6. Should I return only the number of changes needed to make these substrings anagrams, or provide additional output if needed?
     *      yes!
     *
     * Big O Notation:
     *  Time: O(n), where n is the length of the string, since we iterate through the string once to update frequencies.
     *  Space: O(1), as the frequency array has a fixed size of 26.
     *
     * @param s The input string to analyze
     * @return The number of changes required to make the two halves anagrams (if applicable)
     */

    /**
     * Most efficient approach
     *
     * Big O Notation:
     *  Time: O(n), where n is the length of the string, since we iterate through the string once to update frequencies.
     *  Space: O(1), as the frequency array has a fixed size of 26.
     *
     * @param s The input string to analyze
     * @return The number of changes required to make the two halves anagrams (if applicable)
     */
    public static int anagram(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("String must be not null");

        if(s.length() % 2 != 0)
            return -1; // Return -1 to indicate that an anagram is not possible for odd-length strings.
        
        int[] frequencies = new int[26];
        int middle = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(i < middle){
                frequencies[index]++;
            } else {
                frequencies[index]--;
            }
        }

        int changes = 0;
        for (int frequency : frequencies) {
            if(frequency != 0)
                changes += Math.abs(frequency);
        }

        return changes/2;

    }

    public static int anagram2(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("String must be not null");

        if(s.length() % 2 != 0)
            return -1; // Return -1 to indicate that an anagram is not possible for odd-length strings.

        int[] frequencies = new int[26];
        int middle = s.length() / 2;

        String string1 = s.substring(0, middle);
        String string2 = s.substring(middle);

        for (int i = 0; i < middle; i++) {
            int indexA = string1.charAt(i) - 'a';
            frequencies[indexA]++;

            int indexB = string2.charAt(i) - 'a';
            frequencies[indexB]--;
        }

        int changes = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] != 0)
                changes += Math.abs(frequencies[i]);
        }

        return changes/2;
    }

}
