package exercises.hackerrank.palindrome;

public class PalindromeMinIndexDelete {
    public static void main(String[] args) {
        String s = "aaab";
//        String s = "madam";
//        String s = "madamc";
//        String s = "cmadam";
//        String s = "mcadaxm";
//        String s = "madacm";
//        String s = "baa";
//        String s = "aaa";
//        String s = "abcd";
//        String s = "abbd";
//        String s = "iynilxchelphhsjiftgmbtaxlnbrbhsrptfxfddmhoerxaaaaxreohmddfxftprshbrbnlxatbmgtfishhplehcxlinyi";
//        String s = "aebcbda";
//        String s = "abcba";
        int minDeletionsToPalindrome = minDeletionsToPalindrome(s);
        System.out.println("Min deletes: " + minDeletionsToPalindrome);
    }

    /**
     * Two pointer technique
     *
     * Big O Notation
     *  Time:
     *  Space
     *
     *
     * @param s
     * @return
     */
    private static int minDeletionsToPalindrome(String s){
        if (s == null || s.isBlank()) return 0;
        return findMinDeletions(s, 0, s.length()-1);
    }

    // aebcbda
    // aaab
    private static int findMinDeletions(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                // Option 1: Remove the character at `left`
                int minDeletesLeft = findMinDeletions(s, left+1, right);

                // Option 2: Remove the character at `right`
                System.out.println("MinDeletesRight...");
                int minDeletesRight = findMinDeletions(s, left, right-1);

                // Return the minimum of the two options plus 1 for the removal
                int result = 0;
                if(minDeletesLeft < minDeletesRight){
                    return 1 + minDeletesLeft;
                }else{
                    return 1 + minDeletesRight;
                }
//                return 1 + Math.max(minDeletesLeft, minDeletesRight);
            }
            left++;
            right--;
        }

        return 0; // No deletions needed if the substring is already a palindrome
    }


    public static boolean isPalindromeHelper(String s, int left, int right){
        if(s == null || s.isBlank()) return false;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }



    // Dynamic Programming (HELL!)
    // O(n^2)
    private static int minDeletionsToPalindrome1(String s){
        if (s == null || s.isBlank()) return 0;
        int stringSize = s.length();

        // 1 because a single character is a palindrome of length 1.
        int[][] dp = new int[stringSize][stringSize];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < stringSize; i++) {
            dp[i][i] = 1;
        }

        // Build the dp array
        for (int length = 2; length <= stringSize; length++) {
            for (int i = 0; i < stringSize - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int lpsLength = dp[0][stringSize - 1];
        return stringSize - lpsLength;
    }

}
