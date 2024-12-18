package exercises.leetcode;

public class Palindrome {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println("The String '" + s1 + "' isPalindrome? " + isPalindrome(s1));
        System.out.println("The String '" + s2 + "' isPalindrome? " + isPalindrome(s2));
        System.out.println("The String '" + s3 + "' isPalindrome? " + isPalindrome(s3));
    }

    /**
     * BEST approach
     *
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * The use of the two-pointer approach (left and right pointers) is an optimal way to compare characters from
     * both ends of the string simultaneously.
     * It handles non-alphanumeric characters by skipping them, ensuring that only alphanumeric characters are considered,
     * which is typical for palindrome checks.
     * It also normalizes the characters to lowercase before comparing, making the check case-insensitive.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null)
            throw new IllegalArgumentException("Must be not null");

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftValue = s.charAt(left);
            char rightValue = s.charAt(right);

            if (!Character.isLetterOrDigit(leftValue)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightValue)) {
                right--;
            } else {
                if (Character.toLowerCase(leftValue) != Character.toLowerCase(rightValue))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(n)
     *
     * Is a good implementation but we have more Space complexity because of StringBuilder.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s){
        if(s == null) return false;
        StringBuilder sanitizedString = new StringBuilder();
        for(char c : s.toCharArray()) // O(n)
            if(Character.isLetterOrDigit(c)) {
                sanitizedString.append(Character.toLowerCase(c));
            }
        int left = 0;
        int right = sanitizedString.length()-1;

        while(left < right){ // O(n)
            if (sanitizedString.charAt(left) != sanitizedString.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


}
