package exercises.hackerrank;

public class FunnyStringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "acxz";
        String s3 = "bcxz";
        String s4 = " ";
        String s5 = "a";
        String s6 = null;
        System.out.println(funnyString(s1));
        System.out.println(funnyString(s2));
        System.out.println(funnyString(s3));
//        System.out.println(funnyString(s4));
//        System.out.println(funnyString(s5));
//        System.out.println(funnyString(s6));
    }

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * 1. Check String Null, Empty or Blank
     * 2. Check String with less than 2 characters
     * 3. Get ASCII values from Original and Reversed String
     * 4. Get absolute difference between adjacent values for both strings
     * 5. Compare if it is Equal or not. If it's equal then returns Funny, otherwise, returns Not Funny.
     *
     * String = "abc", [97,98,99], Diff [1,1]
     * String = "cba", [99,98,97], Diff [1,1]
     * -> Funny
     *
     * @param s
     * @return
     */
    private static String funnyString(String s){
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");

        int stringSize = s.length();
        if(stringSize < 2) throw new IllegalArgumentException("Must have at least two characters");

        for (int i = 1; i < stringSize; i++) {
            int leftDiff = Math.abs((int) s.charAt(i) - (int) s.charAt(i-1));
            int rightDiff = Math.abs((int) s.charAt(stringSize - i) - (int) s.charAt(stringSize - i - 1));
            if(leftDiff != rightDiff){
                return "Not Funny";
            }
        }
        return "Funny";
    }

}
