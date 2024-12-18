package exercises.hackerrank;

public class HackerrankInAString {
    public static void main(String[] args) {
//        String s = "hereiamstackerrank";
//        String s = "hhaacckkekraraannk";
//        String s = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt";
        String s = "hackerworld";
//        String s = "r h b a a s d n d f s d s k g b f e f d b r s d f h u y a t r j t c r t y y t k t j j t";

        String result = hackerrankInString(s);
        System.out.println(result);
    }

    // hereiamstackerrank
    // hac kerrank

    /**
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     *
     *
     * @param s
     * @return
     */
    public static String hackerrankInString(String s){
        if(s == null || s.isBlank()) return "NO";

        String hackerrank = "hackerrank";
        if(s.length() < hackerrank.length())
            return "NO";

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(j < hackerrank.length() && s.charAt(i) == hackerrank.charAt(j)){
                j++;
            }
        }

        if(j == hackerrank.length()){
            return "YES";
        }else{
            return "NO";
        }
    }


    public static String hackerrankInString1(String s) {
        if(s == null || s.isBlank())
            return "NO";

        String hackerrank = "hackerrank";
        int[] charFrequencies = new int[26];

        for (int i = 0; i < hackerrank.length(); i++) {
            char value = hackerrank.charAt(i);
            int index = value - 'a';
            charFrequencies[index]++;
        }

        // [ 2, 0, 1, 0, 1, 0, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 ]
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            int index = value - 'a';
            charFrequencies[index]--;
        }

        for (int charFrequency : charFrequencies) {
            if (charFrequency > 0)
                return "NO";
        }

        return "YES";
    }

}
