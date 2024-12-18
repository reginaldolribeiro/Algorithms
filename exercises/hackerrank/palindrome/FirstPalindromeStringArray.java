package exercises.hackerrank.palindrome;

public class FirstPalindromeStringArray {
    public static void main(String[] args) {
        String[] words = new String[]{"abc","car","ada","racecar","cool"};
        String result1 = firstPalindrome(words);
        System.out.println("First Palindrome: " + result1);

        String[] words2 = new String[]{"notapalindrome","racecar"};
        String result2 = firstPalindrome(words2);
        System.out.println("First Palindrome: " + result2);

        String[] words3 = new String[]{"def","ghi"};
        String result3 = firstPalindrome(words3);
        System.out.println("First Palindrome: " + result3);

        String[] words4 = new String[]{"def","","ghi"};
        String result4 = firstPalindrome(words4);
        System.out.println("First Palindrome: " + result4);
    }

    /**
     *
     *
     * Big O Notation:
     * - Time: O(n * m), where "n" is the number of strings and "m" is the maximum string length.
     * - Space: O(1)
     *
     * @param words
     * @return
     */
    private static String firstPalindrome(String[] words) {
        if(words == null || words.length == 0)
            return "";
        for (String word : words) { // O(n * m), where n is the number of strings and m is the maximum string length.
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){ // Maximum O(n)
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}
