package exercises.hackerrank;

import java.util.*;

public class AnagramsInString {
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

//        String s = "abab";
//        String p = "ab";

        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";

        var result = findAnagrams(s,p);
        System.out.println(result);
    }

    /**
     *
     * Clarification Questions
     * 1. Handling Null or Empty Strings:
     * 	•	If either s or p is null or empty, return an empty array.
     * 2. Maximum String Length:
     * 	•	Both s and p can have lengths up to 30,000 characters.
     * 3. Expected Output:
     * 	•	Yes, return a list of all starting indices in s where the substring is an anagram of p.
     *
     * @param s
     * @param p
     * @return
     */
    private static List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s == null || s.isBlank() || p == null || p.isBlank())
            return result;

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // If string "p" is greater than string "s", is not possible to find an anagram
        if(p.length() > s.length())
            return result;

        // Initialize frequency count for p and the first window in s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        // Slide the window over string s
        for (int i = p.length(); i < s.length(); i++) {
            int firstWindowIndex = i - p.length();
            if(Arrays.equals(pCount, windowCount)){
                result.add(firstWindowIndex);
            }

            // Add new char to the window
            char currentValue = s.charAt(i);
            windowCount[currentValue - 'a']++;

            // Remove the character that's no longer in the window
            char firstWindowValue = s.charAt(firstWindowIndex);
            windowCount[firstWindowValue - 'a']--;
        }
        // Check last window
        if(Arrays.equals(pCount, windowCount)){
            result.add(s.length() - p.length());
        }

        return result;
    }



    private static List<Integer> findAnagrams1(String s, String p){
        if(s == null || s.isBlank() || p == null || p.isBlank()){
            return new ArrayList<>();
        }

        int size = p.length();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i <= s.length()-size; i++) { // O(n*3)
            String extractedSubstring = s.substring(i, i+size);
            if(isAnagram(extractedSubstring, p)){
                results.add(i);
            }
        }
        return results;
    }

    private static boolean isAnagram(String first, String second) {
        int[] frequencies = new int[26];
        for (int i = 0; i < second.length(); i++) {
            int firstIndex = first.charAt(i) - 'a';
            frequencies[firstIndex]++;

            int secondIndex = second.charAt(i) - 'a';
            frequencies[secondIndex]--;
        }

        for (int frequency : frequencies) {
            if (frequency != 0)
                return false;
        }

        return true;
    }


}
