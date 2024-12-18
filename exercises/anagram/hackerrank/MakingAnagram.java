package exercises.anagram.hackerrank;

public class MakingAnagram {
    public static void main(String[] args) {

        System.out.println("a".isBlank());

        String s1 = "cde";
        String s2 = "abc";
//        String s1 = "abc";
//        String s2 = "amnop";
//        String s1 = "absdjkvuahdakejfnfauhdsaavasdlkj";
//        String s2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";
        int count = makingAnagrams(s1,s2);
        System.out.println(count);
    }

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int makingAnagrams(String s1, String s2) {
        if(s1 == null || s1.isBlank()) throw new IllegalArgumentException("Must be a valid String");
        if(s2 == null || s2.isBlank()) throw new IllegalArgumentException("Must be a valid String");

        // The strings are already anagrams
        if(s1.equals(s2)) return 0;

        int[] charFrequencies = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            if(!Character.isWhitespace(value)){
                int index = Character.toLowerCase(value) - 'a';
                charFrequencies[index]++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            if(!Character.isWhitespace(value)){
                int index = Character.toLowerCase(value) - 'a';
                charFrequencies[index]--;
            }
        }

        int deletes = 0;
        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] != 0){
                deletes += Math.abs(charFrequencies[i]);
            }
        }

        return deletes;
    }

}
