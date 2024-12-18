package exercises.hackerrank;

import java.util.*;

public class TwoCharacters {
    public static void main(String[] args) {
        String s = "abaacdabd";
//        String s = "abacacdebd";
//        String s = "beabeefeab";
//        String s = "asvkugfiugsalddlasguifgukvsa";
        int result = alternate(s);
        System.out.println("Alternate " + result);
    }

//    char1 = a, char2 = b
//    [b,a,b,a,b]
//
//    char1 = b, char2 = e
//    [b,e,b,e,e,e,b]

    /**
     * Big O Notation
     *  Time: O(n^2)
     *  Space: O()
     *
     *
     * @param s
     * @return
     */
    private static int alternate(String s){
        if(s == null || s.isBlank()) return 0;

        Set<Character> uniqueChars = new HashSet<>();
        for(char c : s.toCharArray()){
            uniqueChars.add(c);
        }

        int maxLenght = 0;
        List<Character> uniqueList = new ArrayList<>(uniqueChars);

        for (int i = 0; i < uniqueList.size(); i++) {
            for (int j = i+1; j < uniqueList.size(); j++) {
                char currentValue = uniqueList.get(i);
                char nextValue = uniqueList.get(j);

                int length = validateAlternating(s, currentValue, nextValue);
                maxLenght = Math.max(maxLenght, length);
            }
        }
        
        return maxLenght;
    }

    private static int validateAlternating(String s, char currentValue, char nextValue) {
        int count = 0;
        char lastChar = 0;
        for(char c : s.toCharArray()){
            if(c == lastChar) return 0;
            if(c == currentValue || c == nextValue){
                count++;
                lastChar = c;
            }
        }
        return count;
    }

    // String s = "abaacdabd";
    private static int alternate1(String s){
        if(s == null || s.isBlank()) return 0;

        Set<Character> uniqueChars = new HashSet<>();
        for(char c : s.toCharArray()){
            uniqueChars.add(c);
        }

        int maxLenght = 0;
        List<Character> uniqueList = new ArrayList<>(uniqueChars);

        for (int i = 0; i < uniqueList.size(); i++) { // O(n) * O(n) = O(n^2)
            for (int j = i+1; j < uniqueList.size(); j++) { // O(n)
                char currentValue = uniqueList.get(i);
                char nextValue = uniqueList.get(j);
                StringBuilder filtered = new StringBuilder();
                for(char c : s.toCharArray()){ // O(n)
                    if(c == currentValue || c == nextValue){
                        filtered.append(c);
                    }
                }
                System.out.println("String " + filtered.toString());

                if(isAlternating(filtered.toString())) {
                    System.out.println(" -> Valid String " + filtered.toString());
                    maxLenght = Math.max(maxLenght, filtered.length());
                }
            }
        }
        return maxLenght;
    }

    private static boolean isAlternating(String s){
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }

    // abaacdabd
    private static int alternate2(String s){
        if(s == null || s.isBlank()) return 0;

        Map<List<Character>, Integer> pairs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(i+1 < s.length()){
                char currentValue = s.charAt(i);
                char nextValue = s.charAt(i + 1);
                if(currentValue != nextValue){
                    List<Character> pair = Arrays.asList(currentValue, nextValue);
                    pairs.put(pair, pairs.getOrDefault(pair,0)+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        StringBuilder maxPair = new StringBuilder();
        for(Map.Entry<List<Character>, Integer> entry : pairs.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                List<Character> characters = entry.getKey();
                maxPair = new StringBuilder().append(characters.get(0)).append(characters.get(1));
            }
        }

        StringBuilder resultPair = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i+1 < s.length()){
                char currentValue = s.charAt(i);
                char nextValue = s.charAt(i + 1);
                if(maxPair.compareTo(new StringBuilder().append(currentValue).append(nextValue)) == 0){
                    resultPair.append(currentValue).append(nextValue);
                }
            }
        }

        return resultPair.length();
    }

}
