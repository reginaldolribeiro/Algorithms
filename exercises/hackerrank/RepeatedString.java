package exercises.hackerrank;

public class RepeatedString {

    /**
     * Clarification Questions
     * 1. Does this problem involve passing a string and a number n, where the string’s characters are repeated
     *  until reaching length n, and the task is to count the number of occurrences of the letter “a”?
     * 2. How should I handle null or empty strings? Should I throw an exception or return 0?
     * 3. How should I handle cases where n equals 0?
     * 4. What should I return if the string does not contain the letter “a”?
     * 5. Does the input string only contain English alphabet letters?
     * 6. Can the value of n be infinite, or is it guaranteed to be finite?
     *
     *
     * @param args
     */

    public static void main(String[] args) {
//        String s = "abcac";
//        long n = 10L;

//        String s = "aba";
//        long n = 10L;

//        String s = "a";
//        long n = 1000000000000L;

        String s = "gfcaaaecbg";
        long n = 547602L;

        long result = repeatedString(s,n);
        System.out.println(result);
    }

    // aba -> n = 10 -> abaabaabaa
    private static long repeatedString(String s, long n) {
        if(s == null || s.isBlank() || n == 0) {
            return 0;
        }
        long totalStringInsideN = n / s.length();
        long countAInS = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                countAInS++;
            }
        }

        long totalA = totalStringInsideN * countAInS;
        long remainingChars = n % s.length();
        for (int i = 0; i < remainingChars; i++) {
            if(s.charAt(i) == 'a')
                totalA++;
        }
        
        return totalA;
    }



    private static long repeatedString2(String s, long n) {
        if(s == null || s.isBlank() || n == 0) {
            return 0;
        }

        long counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                counter++;
        }

        // 2 'a' - 3 length
        // ????? - 10 length
        double result = (counter * n) / (double) s.length();
        return Math.round(result);
    }





    /**
     * It works but is not efficient
     *
     * @param s
     * @param n
     * @return
     */
    private static long repeatedString1(String s, long n) {
        if(s == null || s.isBlank() || n == 0) {
            return 0;
        }

        int[] arr = new int[26];
        int size = s.length()-1;

        int j = 0;
        for (int i = 0; i <= n-1; i++) {
            if(j > size){
                j = 0;
            }
            if(j <= size){
                char c = s.charAt(j);
                int index = c - 'a';
                arr[index]++;
                j++;
            }
        }

        return arr[0];
    }

}
