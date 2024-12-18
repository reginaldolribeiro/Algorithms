package exercises.hackerrank.palindrome;

public class PalindromeIndexDelete {
    public static void main(String[] args) {
//        String s = "aaab";
//        String s = "madam";
//        String s = "madamc";
//        String s = "cmadam";
//        String s = "mcadaxm";
//        String s = "madacm";
//        String s = "baa";
//        String s = "aaa";
//        String s = "abcd";
        String s = "abbd";
//        String s = "iynilxchelphhsjiftgmbtaxlnbrbhsrptfxfddmhoerxaaaaxreohmddfxftprshbrbnlxatbmgtfishhplehcxlinyi";
        int index = palindromeIndex(s);
        System.out.println("Index to be removed: " + index);

        System.out.println("isPalindrome? " + isPalindrome(s));
//        System.out.println("isPalindrome? " + isPalindrome1(s));
//        System.out.println("isPalindrome? " + isPalindrome2(s));
    }

    public static int palindromeIndex(String s) {
        if(s == null || s.isBlank()) return -1;

        int left = 0;
        int right = s.length()-1;

        if(isPalindromeHelper(s, left, right)) return -1;

        while((left < right)){ // Possibility to run in O(n^2) when the string it cant be a palindrome
            if(s.charAt(left) != s.charAt(right)){
                if(isPalindromeHelper(s, left, right-1)){ // O(n)
                    return right;
                }
                if(isPalindromeHelper(s, left+1, right)){ // O(n)
                    return left;
                }
            }
            left++;
            right--;
        }

        return -1;
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


    public static int palindromeIndex1(String s) {
        if(s == null || s.isBlank()) return -1;
        if(isPalindrome(s)) return -1;

        int left = 0;
        int right = s.length()-1;
        boolean directionLeftToRight = true;
        StringBuilder stringBuilder = new StringBuilder(s);

        while((left < right) && stringBuilder.length() > 1 && !isPalindrome(stringBuilder.toString())){
            if(s.charAt(left) != s.charAt(right)){
                System.out.println("Char diff " + s.charAt(left) + ", " + s.charAt(right));
                if(directionLeftToRight){

                    if(isPalindrome(s.substring(left, right-1))){
                        return right;
                    }
                    if(isPalindrome(s.substring(left+1, right))){
                        return left;
                    }
                    right--;


                    stringBuilder.deleteCharAt(right); // remove right
                    if(isPalindrome(stringBuilder.toString())) {
                        System.out.println("Index to be removed: " + right);
                        return right;
                    }
                    right--;
                } else {
                    stringBuilder.deleteCharAt(left);
                    if(isPalindrome(stringBuilder.toString())) {
                        System.out.println("Index to be removed: " + left);
                        return left;
                    }
                    left++;
                }
            }
        }

        return -1;
    }

    public static int palindromeIndex2(String s) {
        if(s == null || s.isBlank()) return -1;
        if(isPalindrome(s)) return -1;

        int left = 0;
        int right = s.length()-1;
        int count = 0;
        boolean directionLeftToRight = true;
//        Set<String> remove = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder(s);

        while((left <= right) && stringBuilder.length() > 1 && !isPalindrome(stringBuilder.toString())){
            if(s.charAt(left) != s.charAt(right)){
                System.out.println("Char diff " + s.charAt(left) + ", " + s.charAt(right));
                if(directionLeftToRight){
                    stringBuilder.deleteCharAt(right); // remove right
                    if(stringBuilder.length() < 2){
                        left = 0;
                        right = s.length()-1;
                        stringBuilder = new StringBuilder(s);
                        directionLeftToRight = false;
                    } else {
                        if(isPalindrome(stringBuilder.toString())) {
                            System.out.println("Index to be removed: " + right);
                            return right;
                        }
                        right--;
                    }
                } else {
                    stringBuilder.deleteCharAt(left);
                    if(stringBuilder.length() < 2){
                        return -1;
                    } else {
                        if(isPalindrome(stringBuilder.toString())) {
                            System.out.println("Index to be removed: " + left);
                            return left;
                        }
                        left++;
                    }
                }
            }
        }

        return -1;
    }


    /**
     * Big O Notation
     *  Time complexity: O(n), where "n" is the length of the string.
     *  Space complexity: O(1) as it only uses a few extra variables (left, right) regardless of the size of the input string.
     *                      This makes it more space-efficient than your previous approach.
     *
     *  This approach is straightforward but might be not the most space-efficient.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        if(s == null || s.isBlank()) return false;
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

    /**
     * Big O Notation
     *  Time complexity: O(n), where "n" is the length of the string.
     *  Space complexity: O(n) due to the additional space used to store the reversed string.
     *
     *  This approach is straightforward but might be not the most space-efficient.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    // madam
    public static boolean isPalindrome2(String s){
        int left = 0;
        int right = s.length()-1;

        char[] reversed = new char[s.length()];
        while(right >= 0){
            reversed[right] = s.charAt(left);
            left++;
            right--;
        }
        String stringReversed = new String(reversed);
        return s.equals(stringReversed);
    }

}
