package exercises.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x1 = 121;
        int x2 = 122;
        int x3 = 111;
        int x4 = -121;
        System.out.println("'" + x1 + "' is a palindrome? " + isPalindrome(x1));
        System.out.println("'" + x2 + "' is a palindrome? " + isPalindrome(x2));
        System.out.println("'" + x3 + "' is a palindrome? " + isPalindrome(x3));
        System.out.println("'" + x4 + "' is a palindrome? " + isPalindrome(x4));
    }

    /**
     * BEST approach
     *
     * Big O Notation:
     * 	Time Complexity: O(n), where n is the number of digits in the integer.
     * 	Space Complexity: O(1), because only a few integer variables are used.
     *
     * Check if a given integer is a palindrome.
     * A palindrome reads the same forwards and backwards, and negative numbers are not considered palindromes.
     *
     * Solution
     * 	1.	Check if the integer is negative: If so, return false.
     * 	2.	Reverse the integer:
     * 	    • Extract digits from the end of the integer.
     * 	    • Build the reversed integer by appending these digits.
     * 	3.	Compare the reversed integer with the original integer. If they are the same, return true; otherwise, return false.
     *
     *
     * @param x
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if(x < 0) return false;

        int original = x;
        int reversed = 0;

        // Reverse the integer
        while(x != 0){
            int digit = x % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Append the digit to reversed number
            x = x/10; // Remove the last digit from x
        }
        return original == reversed;
    }

    /**
     * Less efficient approach because it needs to converter the int to String to iterate through string
     *
     * Big O Notation
     *  Time Complexity: O(n), where n is the number of digits in the integer.
     *  Space Complexity: O(n), due to the space required to store the string representation of the integer.
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
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
