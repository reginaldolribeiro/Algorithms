package exercises.hackerrank.palindrome;

public class PalindromeTest {

    /**
     * Clarification Questions:
     * 1.	How should I handle empty or blank strings? Should I return false, true, or throw an error?
     * 2.	Are there any specific performance expectations, such as a strict Big O notation requirement?
     * 3.	Can the input string be very large? Should I optimize for performance in such cases?
     * 4.	The problem mentions that the string is ASCII, which includes symbols. Should I ignore non-alphanumeric characters (symbols) and only compare letters and numbers?
     *
     *
     * Alphanumeric characters (letters and digits) are part of the ASCII character set.
     *
     * @param args
     */


    public static void main(String[] args) {
        String s1 = "madam";
        String s2 = "madamc";
        String s3 = "baa";
        String s4 = "aaa";
        String s5 = "A man, a plan, a canal: Panama";
        String s6 = "race a car";
        String s7 = " ";
        System.out.println("'" + s1 + "' is a palindrome? " + isPalindrome(s1));
        System.out.println("'" + s2 + "' is a palindrome? " + isPalindrome(s2));
        System.out.println("'" + s3 + "' is a palindrome? " + isPalindrome(s3));
        System.out.println("'" + s4 + "' is a palindrome? " + isPalindrome(s4));
        System.out.println("'" + s5 + "' is a palindrome? " + isPalindrome(s5));
        System.out.println("'" + s6 + "' is a palindrome? " + isPalindrome(s6));
        System.out.println("'" + s7 + "' is a palindrome? " + isPalindrome(s7));
    }


    /**
     * 1. Check if the string is null or empty
     * 2. Create to pointers: left and right
     * 3. Check if the values are not spaces
     * 4. Convert the values to lowercase
     *
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if(s == null)
            return false;

        if(s.isBlank())
            return true;

        int left = 0;
        int right = s.length()-1;

        while(left <= right){ // O(n)
            char leftValue = s.charAt(left);
            char rightValue = s.charAt(right);
            if(!Character.isLetterOrDigit(leftValue)){
                left++;
            } else if (!Character.isLetterOrDigit(rightValue)){
                right--;
            } else {
                if(Character.toLowerCase(leftValue) != Character.toLowerCase(rightValue))
                    return false;

                left++;
                right--;
            }

        }
        return true;
    }

}
