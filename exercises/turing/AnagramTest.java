package exercises.turing;

public class AnagramTest {
    public static void main(String[] args) {
//        String a = "anagram";
//        String b = "margana";
        String a = "aaabbb";
        String b = "bbbaaa";

        System.out.println( (isAnagram(a, b)) ? "Anagrams" : "Not Anagrams" );
    }

    private static boolean isAnagram(String a, String b){
        if(a == null || a.isBlank() || b == null || b.isBlank())
            throw new IllegalArgumentException("INvalid strings");

        if(a.length() != b.length())
            return false;

        int[] frequencies = new int[26];
        for (int i = 0; i < a.length(); i++) {
            int firstIndex = a.charAt(i) - 'a';
            frequencies[firstIndex]++;

            int secondIndex = b.charAt(i) - 'a';
            frequencies[secondIndex]--;
        }

        for (int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] != 0)
                return false;
        }
        return true;
    }
}
