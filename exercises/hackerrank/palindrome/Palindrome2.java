package exercises.hackerrank.palindrome;

public class Palindrome2 {

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";
        String s4 = "abcde";
        String s5 = "aeecee";
        System.out.println("'" + s1 + "' is a palindrome? " + isPalindrome(s1));
        System.out.println("'" + s2 + "' is a palindrome? " + isPalindrome(s2));
        System.out.println("'" + s3 + "' is a palindrome? " + isPalindrome(s3));
        System.out.println("'" + s4 + "' is a palindrome? " + isPalindrome(s4));
        System.out.println("'" + s5 + "' is a palindrome? " + isPalindrome(s5));
    }

    private static boolean isPalindrome(String s) {
        if(s == null)
            return false;

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindromeHelper(s, left + 1, right) || isPalindromeHelper(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeHelper(String s, int left, int right){
        while(left < right){
            char leftValue = s.charAt(left);
            char rightValue = s.charAt(right);
            if(!Character.isLetterOrDigit(leftValue)){
                left++;
            } else if (!Character.isLetterOrDigit(rightValue)){
                right--;
            } else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
