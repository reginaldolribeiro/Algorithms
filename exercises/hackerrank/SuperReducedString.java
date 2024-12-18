package exercises.hackerrank;

public class SuperReducedString {
    public static void main(String[] args) {
//        String originaString = "aab";
//        String originaString = "abba";
//        String originaString = "aaabccddd";
        String originaString = "lrfkqyuqfjjfquyqkfrlkxyqvnrtyssytrnvqyxkfrzrmzlygffgylzmrzrfveulqfpdbhhbdpfqluevlqdqrrcrwddwrcrrqdql";
//        String originaString = "";
        System.out.println("Original string: " + originaString);
        String result = superReducedString(originaString);
        System.out.println("\nResult: " + result);
    }

    /**
     * 	Best approach
     *
     * 	Big O Notation
     * 	    Time Complexity: O(n) because each character is processed once, either being appended or causing
     * 	                        the previous character to be deleted.
     * 	    Space Complexity: O(n) for the StringBuilder, where n is the length of the input string.
     *
     * 	IF StringBuilder is empty ->
     *      YES -> Add value to StringBuilder
     *      NO  -> check IF current String value is equal to the StringBuilder value in last position
     *          YES -> Remove from StringBuilder
     *          NO  -> Add value to StringBuilder
     *
     *  IF StringBuilder is empty ->
     *      YES -> Return "Empty String"
     *      NO  -> Return StringBuilder
     *
     *
     * @param s
     * @return
     */
    private static String superReducedString(String s) {
        if(s.isEmpty() || s.isBlank()) return "Empty String";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int sbLength = sb.length();
            if(sbLength > 0 && s.charAt(i) == sb.charAt(sbLength -1)){
                sb.deleteCharAt(sbLength -1); // Remove the matching pair
            } else {
                sb.append(s.charAt(i)); // Add the character to the StringBuilder
            }
        }
        return sb.length() == 0 ? "Empty String" : sb.toString();
    }

//    private static String superReducedString(String s) {
//        if(s.isEmpty() || s.isBlank()) return "Empty String";
//
//        StringBuilder sb = new StringBuilder(s);
//        int i = 0;
//
//        while(sb.length() >= 2 && i < sb.length()-1){
//            if(sb.charAt(i) == sb.charAt(i+1)){
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i); // After deleting at i, the next char to delete is also at i
//                i = 0; // Restart from the beginning
//            }else{
//                i++;
//            }
//        }
//
//        return sb.isEmpty() ? "Empty String" : sb.toString();
//    }
}




