package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring2 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "abba";
//        String s = "abcde";
//        String s = "dvdf";
//        String s = " ";
        int result = longestSubstring(s);
        System.out.println(result);
    }

    /**
     * 1. Create a Map to store the current element and their index {'a',0}
     * 2. Create variables:
     *  - two pointer: start and i (index of loop)
     *  - maxLength = 0
     * 3. For each iteration, check if the Map contains the current element and if it is:
     *      - Get their index and sum +1
     *      - Compare "start" with the calculation (index+1) and the greater number it will be assigned to "start"
     * 4. Subtract current index with "start" and sum +1
     * 5. Check if the result is greater than "maxLength" and if it is assign this result to maxLength
     * 6. Add this current value as a key and their index as a value
     * 7. When the loop is ended, return the maxLength
     *
     * @param s
     * @return
     */
    // abcabcbb
    public static int longestSubstring(String s){
        if(s == null || s.isEmpty())
            return 0;

        int start = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            char value = s.charAt(i);
            if(map.containsKey(value)){
                int index = map.get(value);
                start = Math.max(start, index+1);
            }
            maxLength = Math.max(maxLength, i - start + 1);
            map.put(value, i);
        }

        return maxLength;
    }
    
}
