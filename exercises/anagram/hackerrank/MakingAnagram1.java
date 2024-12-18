package exercises.anagram.hackerrank;

public class MakingAnagram1 {
    public static void main(String[] args) {

        System.out.println("a".isBlank());

//        String s1 = "cde";
//        String s2 = "abc";
        String s1 = "abc";
        String s2 = "amnop";
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
        if(s1 == null || s1.isBlank() || s2 == null || s2.isBlank())
            throw new IllegalArgumentException("String must be not null and not empty.");

        if(s1.equals(s2))
            return 0;

        int[] frequencies = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            frequencies[index]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            frequencies[index]--;
        }

        int deletions = 0;
        for(Integer value : frequencies){
            if(value != 0)
                deletions += Math.abs(value);
        }

        return deletions;
    }

}
