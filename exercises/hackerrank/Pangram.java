package exercises.hackerrank;

public class Pangram {

    public static void main(String[] args) {
//        String s = "We promptly judged antique ivory buckles for the next prize";
//        String s = "We promptly judged antique ivory buckles for the prize";
        String s = "qmExzIJmdELxyOFWv LOCmefk TwPhargKSPEqSxzveiun";
//        String s = " a";
        String result = pangrams(s);
        System.out.println(result);
    }

    /**
     * Most efficient
     *
     * Big O Notation:
     *  Time: O(n)
     *  Space: O(1), because in the context of English alphabet fixed size of 26 letters.
     *
     *  1. Sanitize an input string removing White spaces and converting to Lower case.
     *  2. Create an array to store the Char frequencies of English alphabet (26 letters)
     *  3. Iterate through the String char Sum +1 at each index of char in that string.
     *  3. Iterate through the Array char frequencies checking If there are any position with value 0 (zero),
     *      which means that missing alphabet letter in this String, in this case is Not a Pangram.
     *
     * Alphabet letters
     *  a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
     *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
     *
     * @param s
     * @return
     */
    public static String pangrams(String s){
        if(s == null || s.isBlank())
            throw new IllegalArgumentException("String must be valid");

        int[] charFrequencies = new int[26];

        // Remove white spaces, convert to lower case and populate char frequencies
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if(!Character.isWhitespace(value)){
                int index = Character.toLowerCase(value) - 'a';
                charFrequencies[index]++;
            }
        }

        boolean pangram = true;
        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] == 0){
                pangram = false;
                break;
            }
        }

        return pangram ? "pangram" : "not pangram";
    }

}
