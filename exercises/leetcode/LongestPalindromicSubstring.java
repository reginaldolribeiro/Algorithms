package exercises.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
//        String s = "acbab";
//        String s = "ccc";
        String s = "aaaa";
//        String s = "aa";
        String result = longestPalindromicSubstring(s);
        System.out.println(result);
    }


    /**
     * Finds the longest palindromic substring in the given input string.
     *
     * The function processes the string by increasing substring length, using
     * dynamic programming to determine if a substring is a palindrome by reusing
     * previously computed results.
     *
     * Complexity:
     * - Time: O(n^2) - due to nested loops for substring processing.
     * - Space: O(n^2) - for the DP table.
     *
     * Example inputs and expected results:
     * - Input: "babad" -> Output: "bab" or "aba"
     * - Input: "cbbd"  -> Output: "bb"
     * - Input: "aaaa"  -> Output: "aaaa"
     *
     * @param s the input string to process.
     * @return the longest palindromic substring in the input string.
     * @throws IllegalArgumentException if the input string is null or empty.
     */
    private static String longestPalindromicSubstring(String s) {
        if(s == null || s.isEmpty())
            throw new IllegalArgumentException("String must not be null or empty");

        if(s.length() == 1)
            return s;

        int stringSize = s.length();
        boolean[][] dp = new boolean[stringSize][stringSize];
        // dp[0][0] = true, dp[1][1] = true, dp[2][2] = true ...
        for (int i = 0; i < stringSize; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLength = 1;
        int length = 2;
        // aaaa
        // 0,1  - aa   - dp[0][1] = true -ok
        // 1,2  - aa   - dp[1][2] = true
        // 2,3  - aa   - dp[1][2] = true
        // 0,2  - aaa  - dp[0][2] = true
        // 0,3  - aaaa - dp[0][3] = true
        while(length <= stringSize){
            for (int i = 0; i <= stringSize - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    boolean isLengthTwo = j - i == 1;
                    if(isLengthTwo || dp[i+1][j-1]){
                        dp[i][j] = true;
                        maxLength = length;
                        start = i;
                    }
                }
            }
            length++;
        }

        return s.substring(start, start + maxLength);
    }


    private static String longestPalindromicSubstring1(String s) {
        if(s == null || s.isEmpty())
            throw new IllegalArgumentException("String must not be null or empty");

        int start = 0, maxLength = 0;
        if(s.length() == 1)
            return s;

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                System.out.println("Palindrome");
                if(right - left + 1 > maxLength)
                    maxLength = right - left +1;
                start = left;
            }
            left++;
            right--;
        }

        // expandir para os lados
//        if(maxLength == 0){
//
//        }

        return s.substring(start, start + maxLength);
    }





    /**
     * Quadratic time, not efficient.
     *
     * Big O Notation
     *  Time: O(n^2)
     *  Space: O(n)
     *
     * @param s
     * @return
     */
    private static String longestPalindromicSubstring3(String s) {
        if(s == null || s.isEmpty())
            throw new IllegalArgumentException("String must not be null or empty");

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char firstValue = s.charAt(i);
            stringBuilder.append(firstValue);
            for (int j = i+1; j < s.length(); j++) {
                char secondValue = s.charAt(j);
                stringBuilder.append(secondValue);
                if(isPalindrome(stringBuilder.toString())){
                    if(stringBuilder.toString().length() > result.length()){
                        result = stringBuilder.toString();
                    }
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s){
        if (s == null)
            throw new IllegalArgumentException("Must be not null");

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
