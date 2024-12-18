package exercises.anagram.hackerrank;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
//        String s = "aaaaaa";
        String s = "aaabbb";
//        String s = "ab";
//        String s = "abc";
//        String s = "mnop";
//        String s = "xyyx";
//        String s = "xaxbbbxx";
//        String s = "vakhotzflsuglmkrxowvqrbaegxskgghgrpwmodzjafwornlhlgydjajrybeehlmaajoroncouyconnvywtdfumzsndyxokzrvqkkfoaamdqbslzoffwbtvvjatiqfhjbztnfjnhvsxwliyzpfxqyunjuirnobwrasehbtozmlvxuvylawebsr";
        int changes = anagram(s);
        if(changes >= 0){
            System.out.println("We need " + changes + " changes to make an anagram");
        } else {
            System.out.println("It's not possible to make an Anagram!");
        }
    }

    // a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
//    public static void main(String[] args) {
//        String s1 = "anagram";
//        String s2 = "margana";
//
////        System.out.println(isAnagram1(s1,s2));
//        System.out.println(isAnagram2(s1,s2));
////        System.out.println(isAnagram3(s1,s2));
//    }

    /**
     * MOST Efficient implementation
     *
     * Big O Notation:
     *  Time: O(n)
     *  Space: O(1), because the size of alphabet array is constant (fixed at 26 letter for the English alphabet)
     *
     *
     *  Anagrams are two words that have the same length and can be rearranged to form each other.
     *
     * Given two strings, determine if are anagrams
     *
     * inputs
     *  string1 = "anagrama"
     *  string2 = "margana"
     *
     * Conditions:
     * - String null or blank? return false
     * - String with different length? return false
     *
     * Return: TRUE or FALSE
     *
     * Big O Notation is O(n log n) which is worse than O(n)
     * O(n log n) is because Sort array
     *
     */
    // 1. Inicializar array com tamanho fixo igual ao total de letras do alfabeto e contendo 0 (zero) em todas posicoes
    // 2. Transformar a String 1 em array e percorrer o array pegando qual o indice correto de cada letra
    // 3. Com o indice obtido, pegar o valor contido no indice do array do alfabeto e somar 1. Fazer isso ate
    //    terminar de percorrer todas as letras da String 1
    // 4. Transformar a String 2 em array e percorrer o array pegando qual o indice correto de cada letra
    // 5. Com o indice obtido, pegar o valor contido no indice do array do alfabeto e subtrair 1.
    // 6. Ao final disso se as strings forem anagramas, todas as posicoes do array do alfabeto estarao com valor 0
    // 7. Percorrer o array do alfabeto verificando se tem alguma posicao com o valor diferente de zero, se tiver
    // significa que as strings nao sao anagrama.
    //
    public static boolean isAnagram3(String s1, String s2){
        if(s1 == null || s1.isBlank()) return false;
        if(s2 == null || s2.isBlank()) return false;
        if(s1.length() != s2.length()) return false;

        int[] charFrequencies = new int[26];

        char[] s1CharArray = s1.toCharArray();
        for (int i = 0; i < s1CharArray.length; i++) {
            int index = s1CharArray[i] - 'a';
            charFrequencies[index]++;
//            if(charFrequencies[index] == 0){
//                charFrequencies[index] = 1;
//            } else {
//                charFrequencies[index] = charFrequencies[index] + 1;
//            }
        }

        char[] s2CharArray = s2.toCharArray();
        for (int i = 0; i < s2CharArray.length; i++) {
            int index = s2CharArray[i] - 'a';
            charFrequencies[index]--;
//            if(charFrequencies[index] == 0){
//                charFrequencies[index] = -1;
//            } else {
//                charFrequencies[index] = charFrequencies[index] - 1;
//            }
        }

        for (int i = 0; i < charFrequencies.length; i++) {
            if(charFrequencies[i] != 0) return false;
        }

        return true;
    }


    public static boolean isAnagram2(String s1, String s2){
        if(s1 == null || s1.isBlank()) return false;
        if(s2 == null || s2.isBlank()) return false;
        if(s1.length() != s2.length()) return false;

        Map<Character, Integer> countA = new HashMap<>();
        Map<Character, Integer> countB = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            countA.put(value, countA.getOrDefault(value, 0)+1);
//            if(countA.containsKey(value)){
//                countA.put(value, countA.get(value)+1);
//            } else {
//                countA.put(value, 1);
//            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            countB.put(value, countB.getOrDefault(value, 0)+1);
//            if(countB.containsKey(value)){
//                countB.put(value, countB.get(value)+1);
//            } else {
//                countB.put(value, 1);
//            }
        }

        return countA.equals(countB);
    }

    /**
     * Anagrams are two words that have the same length and can be rearranged to form each other.
     *
     * Given two strings, determine if are anagrams
     *
     * inputs
     *  string1 = "anagrama"
     *  string2 = "margana"
     *
     * Conditions:
     * - String null or blank? return false
     * - String with different length? return false
     *
     * Return: TRUE or FALSE
     *
     * Big O Notation is O(n log n) which is worse than O(n)
     * O(n log n) is because Sort array
     *
     */
    public static boolean isAnagram1(String s1, String s2){
        if(s1 == null || s1.isBlank()) return false;
        if(s2 == null || s2.isBlank()) return false;
        if(s1.length() != s2.length()) return false;

        // podemos ordernar as strings e comparar se sao iguais, porem a complexidade disso seria O(n log n). Podemos melhorar
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);

        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s2CharArray);

        return Arrays.equals(s1CharArray, s2CharArray);
    }


    /**
     * Big O Notation
     *  Time: O(n^2) - quadratic (BAD)
     *  Space: O(n)
     *
     * Anagrams are two words that have the same length and can be rearranged to form each other.
     *
     * Given a string, split it into two contiguous substrings of equal length.
     * Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
     *
     * input = one string
     * input = aaabbb
     *
     * We split  into two strings ='aaa' and ='bbb'.
     * We have to replace all three characters from the first string with 'b' to make the strings anagrams.
     *
     * Conditions:
     * - String null or blank? return -1
     * - String with length odd (impar)? return -1 (String needs to be even (par) ) - Use module operator
     * - String with all character in all of the positions, return 0 (zero)
     *
     * Return: number of changes necessary to make two substrings into anagrams
     *
     */
    private static int anagramCount(String s){
        if(s == null || s.isBlank()) return -1;
        if(s.length()%2 != 0) return -1; // modulus operator ( % )

        int middle = s.length()/2;
        String s1 = s.substring(0, middle); // "aaa"
        String s2 = s.substring(middle, s.length()); // "bbb"

        if(s1.equals(s2)) return 0;

        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = 0;
            for (int j = 0; j < s2.length(); j++) {
                if((s1.charAt(i) == s2.charAt(j)) && count == 0){
                    arr.add(s1.charAt(i));
                    count++;
                }
            }
        }

        int result = s1.length() - arr.size();
        if(result < 0) {
            return -1;
        } else {
            return result;
        }
    }

    /**
     * Most efficient solution
     *
     * Big O Notation
     *  Time: O(n)
     *  Complexity: O(k), where k is the number of characters, and usually O(1) in the context of English alphabet
     *  fixed size of 26 letters.
     *
     *  1. Split the string in two others with the same size
     *  2. Check IF are equal, if it is, return 0 (zero)
     *  3. Create a Map to count a frequency of letters in two strings
     *   3.1 For the First string you will iterate and SUM +1 for each letter
     *   3.2 For the Second String you will iterate and Subtract -1 for each letter.
     *  4. In the end, you will iterate through Map Frequencies checking which letter has value greater than 0 (zero)
     *      and accumulate this sum.
     *      This will be a number of changes required to make strings anagrams.
     *
     * Alphabet letters
     * a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
     */

    // xaxb ({'x': 2}, {'a': 1}, {'b': 1})
    // bbxx ({'x': 2}, {'b': 2})

    private static int anagram(String s){
        if(s == null || s.isBlank()) return -1;

        // Return -1 if modulus operator ( % ) is different zero
        if(s.length()%2 != 0) return -1;

        char firstLetter = s.charAt(0);
        boolean stringWithSameLetter = true;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != firstLetter){
                stringWithSameLetter = false;
                break;
            }
        }

        // Early return if all characters are the same
        if(stringWithSameLetter) return 0;

        int middle = s.length()/2;
        String s1 = s.substring(0, middle); // "aaa"
        String s2 = s.substring(middle, s.length()); // "bbb"

        // Early return if substrings are already equal
//        if(s1.equals(s2)) return 0;

        Map<Character, Integer> mapFrequencies = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            mapFrequencies.put(value, mapFrequencies.getOrDefault(value, 0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            mapFrequencies.put(value, mapFrequencies.getOrDefault(value,0) - 1);
        }

        int changes = 0;
        for(Map.Entry<Character, Integer> entry : mapFrequencies.entrySet()){
            if(entry.getValue() > 0){
                changes += entry.getValue();
            }
        }

        return changes;
    }


    /**
     * 1. Loop through the entire string
     * 2. Get the middle position
     * 3. Compare first position (0) with the first position after the middle (0+middle)
     * 4. If it's the same string, remove it.
     *
     * @param s
     * @return
     */

    // xaxb ({'x': 2}, {'a': 1}, {'b': 1})
    // bbxx ({'x': 2}, {'b': 2})

    private static int anagramCountTest(String s){
        if(s == null || s.isBlank()) return -1;
        if(s.length()%2 != 0) return -1; // modulus operator ( % )

        int middle = s.length()/2;
        String s1 = s.substring(0, middle); // "aaa"
        String s2 = s.substring(middle, s.length()); // "bbb"

        // Early return if substrings are already equal
        if(s1.equals(s2)) return 0;

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            map1.put(value, map1.getOrDefault(value, 0)+1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            map2.put(value, map2.getOrDefault(value, 0)+1);
        }

        // xaxb ({'x': 2}, {'a': 1}, {'b': 1})
        // bbxx ({'x': 2}, {'b': 2})

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()){
            char key = entry.getKey();
            int countMap1 = entry.getValue();
            int countMap2 = map2.getOrDefault(key, 0);

            // Calculate the excess in map1 that needs to be changed
            if (countMap1 > countMap2) {
                count += countMap1 - countMap2;
            }
//            if(!map2.containsKey(entry.getKey())){
//                count += entry.getValue();
//            }
        }

        return count;
    }

}
