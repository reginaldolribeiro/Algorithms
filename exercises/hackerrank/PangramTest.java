package exercises.hackerrank;

public class PangramTest {
    public static void main(String[] args) {
//        String s = "a";
//        System.out.println(Character.toLowerCase(s.charAt(0)));
        String s = "we $promptly judged antique ivory buckles for the next prize";
        System.out.println(pangrams(s));
    }


    // String que contem cada letra do alfabeto
    public static String pangrams(String s){
        if(s == null || s.isBlank())
            return "not pangram";

        int[] charFrequencies = new int[26];
        for (int i = 0; i < s.length(); i++) { // O(n)
            char value = s.charAt(i);
            if(!Character.isWhitespace(value) && Character.isLetter(value)){
                int index = Character.toLowerCase(value) - 'a';
                charFrequencies[index]++;
            }
        }

        for(int i = 0; i < charFrequencies.length; i++){ // O(n)
            if(charFrequencies[i] == 0){
                return "not pangram";
            }
        }

        return "pangram";
    }
}
