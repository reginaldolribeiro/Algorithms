package exercises.hackerrank.palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String s1 = "madam";
        String s2 = "madamc";
        String s3 = "baa";
        String s4 = "aaa";
        System.out.println("'" + s1 + "' is a palindrome? " + isPalindrome(s1));
        System.out.println("'" + s2 + "' is a palindrome? " + isPalindrome(s2));
        System.out.println("'" + s3 + "' is a palindrome? " + isPalindrome(s3));
        System.out.println("'" + s4 + "' is a palindrome? " + isPalindrome(s4));
    }

    public static boolean isPalindrome(String s) {
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
