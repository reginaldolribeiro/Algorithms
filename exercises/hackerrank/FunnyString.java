package exercises.hackerrank;

import java.util.Arrays;

public class FunnyString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "acxz";
        String s3 = "bcxz";
        String s4 = "b";
//        int asciiValue = (int) s.charAt(0);
//        System.out.println(asciiValue);

        System.out.println(funnyString(s1));
        System.out.println(funnyString(s2));
        System.out.println(funnyString(s3));
//        System.out.println(funnyString(s4));
    }

    // a  b  c
    // 97 98 99
    //   1  1
    //
    // c  b  a
    // 99 98 97
    //   1  1

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * 1. Check String Null, Empty or Blank
     * 2. Check String with less than 2 characters
     * 3. Get ASCII values from Original and Reversed String
     * 4. Get absolute difference between adjacent values for both strings
     * 5. Compare if it is Equal or not.
     *  - Is Equal: returns Funny,
     *    otherwise, returns Not Funny.
     *
     * String = "abc", [97,98,99], Diff [1,1]
     * String = "cba", [99,98,97], Diff [1,1]
     * ---> Funny
     *
     * String = "bcxz", [98,99,120,122], Diff [1,21,2]
     * String = "bcxz", [122,120,99,98], Diff [2,21,1]
     * ---> Not Funny
     *
     * @param s
     * @return
     */
    public static String funnyString(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        int stringSize = s.length();
        if(stringSize < 2)
            throw new IllegalArgumentException("Must have least two characters");

        for (int i = 1; i < stringSize; i++) {
            int diffLeft = Math.abs((int) s.charAt(i) - (int) s.charAt(i-1));
            int diffRight = Math.abs((int) s.charAt(stringSize - i) - s.charAt(stringSize - i - 1));
            if(diffLeft != diffRight){
                return "Not Funny";
            }
        }

        return "Funny";
    }


    public static String funnyString1(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        int stringSize = s.length();
        if(stringSize < 2)
            throw new IllegalArgumentException("Must be at least two characters");

        int[] asciiValuesDiff = new int[stringSize-1];
        int[] asciiValuesReversedDiff = new int[stringSize-1];
        int right = asciiValuesReversedDiff.length;
        for (int i = 0; i < stringSize-1; i++) {
            if(i+1 <= stringSize-1){
                int diffLeft = Math.abs((int) s.charAt(i) - (int) s.charAt(i+1));
                asciiValuesDiff[i] = diffLeft;

                int diffRight = Math.abs((int) s.charAt(right) - s.charAt(right-1));
                asciiValuesReversedDiff[i] = diffRight;
                right--;
            }
        }

        return Arrays.equals(asciiValuesDiff, asciiValuesReversedDiff) ? "Funny" : "Not Funny";
    }


    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(n)
     *
     *
     * @param s
     * @return
     */
    public static String funnyString2(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        int stringSize = s.length();
        if(stringSize < 2)
            throw new IllegalArgumentException("Must be at least two characters");

        int[] asciiValues = new int[stringSize];
        int[] asciiValuesDiff = new int[stringSize -1];
        for (int i = 0; i < stringSize; i++) {
            asciiValues[i] = (int) s.charAt(i);
            if(i+1 <= asciiValuesDiff.length) {
                int diff = (int) s.charAt(i) - (int) s.charAt(i + 1);
                asciiValuesDiff[i] = Math.abs(diff);
            }
        }

//        int[] asciiValuesReversed = new int[stringSize];
        int[] asciiValuesReversedDiff = new int[stringSize-1];
        int left = 0;
        for (int i = stringSize-1; i >= 0; i--) {
//            asciiValuesReversed[left] = asciiValues[i];
            if(i>0) {
                int diff = (int) asciiValues[i] - (int) asciiValues[i-1];
                asciiValuesReversedDiff[left] = Math.abs(diff);
            }
            left++;
        }

        return Arrays.equals(asciiValuesDiff, asciiValuesReversedDiff) ? "Funny" : "Not Funny";
    }


    public static String funnyString3(String s) {
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("Must be a valid string");

        int stringSize = s.length();
        if(stringSize < 2)
            throw new IllegalArgumentException("Must be at least two characters");

        int[] asciiValues = new int[stringSize];
        int[] asciiValuesCalculated = new int[stringSize -1];
        for (int i = 0; i < stringSize; i++) {
            asciiValues[i] = (int) s.charAt(i);
            if(i+1 <= asciiValuesCalculated.length) {
                int diff = (int) s.charAt(i) - (int) s.charAt(i + 1);
                asciiValuesCalculated[i] = Math.abs(diff);
            }
        }

        int[] asciiValuesReversed = new int[stringSize];
        int[] asciiValuesCalculatedReversed = new int[stringSize-1];
        int left = 0;
        for (int i = stringSize-1; i >= 0; i--) {
            asciiValuesReversed[left] = asciiValues[i];
            if(i>0) {
                int diff = (int) asciiValues[i] - (int) asciiValues[i-1];
                asciiValuesCalculatedReversed[left] = Math.abs(diff);
            }
            left++;
        }

        return Arrays.equals(asciiValuesCalculated, asciiValuesCalculatedReversed) ? "Funny" : "Not Funny";
    }




    public static String funnyString4(String s) {
        if(s == null || s.isBlank()) throw new IllegalArgumentException("Must be a valid string");
        if(s.length() < 2) throw new IllegalArgumentException("Must be at least two characters");

        int[] asciiValues = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            asciiValues[i] = (int) s.charAt(i);
        }

        int[] asciiValuesCalculated = new int[s.length()-1];
        for (int i = 0; i < s.length()-1; i++) {
            int diff = (int) s.charAt(i) - (int) s.charAt(i+1);
            asciiValuesCalculated[i] = Math.abs(diff);
        }

        int[] asciiValuesReversed = new int[s.length()];
        int left = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            asciiValuesReversed[left] = asciiValues[i];
            left++;
        }

        int[] asciiValuesCalculatedReversed = new int[s.length()-1];
        for (int i = 0; i < asciiValuesCalculatedReversed.length; i++) {
            int diff = (int) asciiValuesReversed[i] - (int) asciiValuesReversed[i + 1];
            asciiValuesCalculatedReversed[i] = Math.abs(diff);
        }

        return Arrays.equals(asciiValuesCalculated, asciiValuesCalculatedReversed) ? "Funny" : "Not Funny";
    }
}
