package exercises.anagram.hackerrank;

import java.util.Arrays;

public class AnagramTest {

    //    public static void main(String[] args) {
//        String s = "aaabbb";
//        int changes = anagram(s);
//        System.out.println("We need " + changes + " changes to make an anagram");
//    }

    /*public static void main(String[] args) {
        String s = "ababaa";
        int middle = s.length() / 2;
        System.out.println("String size: " + s.length() + ". String middle: " + middle);
        String s1 = s.substring(0, middle);
        System.out.println("String1: " + s1);

        String s2 = s.substring(middle, s.length());
        System.out.println("String2: " + s2);

//        String[] strings = "aaa.bbb".split("\\.");
//        for (String st : strings){
//            System.out.println("String spllited: " + st);
//        }

//        System.out.println(s.toCharArray());
//        for(char s1 : s.toCharArray()){
//            System.out.println(s1);
//        }

//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(i);
//        }
    }*/

    // a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    public static void main(String[] args) {
        String s1 = "anagrama";
//        String s2 = "anagrama";
        String s2 = "marganab";
//        System.out.println(s1.contentEquals(s2));
//        System.out.println(s1.equals(s2));

//        System.out.println(isAnagram1(s1,s2));
        System.out.println(isAnagram2(s1,s2));

//        int[] check1 = new int[26];
//        int[] check2 = new int[26];
//
//        char[] s1CharArray = s1.toCharArray();
//        for (int i = 0; i < s1CharArray.length; i++) {
//            int index = s1CharArray[i] - 'a';
//            System.out.println(index);
//            if(check1[index] == 0){
//                check1[index] = 1;
//            } else {
//                check1[index] = check1[index] + 1;
//            }
//        }
//
//        System.out.println("**************");
//        for (int i = 0; i < check1.length; i++) {
//            System.out.println(check1[i]);
//        }

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
    public static boolean isAnagram2(String s1, String s2){
        if(s1 == null || s1.isBlank()) return false;
        if(s2 == null || s2.isBlank()) return false;
        if(s1.length() != s2.length()) return false;

        int[] alphabet = new int[26];

        char[] s1CharArray = s1.toCharArray();
        for (int i = 0; i < s1CharArray.length; i++) {
            int index = s1CharArray[i] - 'a';
            if(alphabet[index] == 0){
                alphabet[index] = 1;
            } else {
                alphabet[index] = alphabet[index] + 1;
            }
        }

        char[] s2CharArray = s2.toCharArray();
        for (int i = 0; i < s2CharArray.length; i++) {
            int index = s2CharArray[i] - 'a';
            if(alphabet[index] == 0){
                alphabet[index] = -1;
            } else {
                alphabet[index] = alphabet[index] - 1;
            }

        }

        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] != 0) return false;
        }

        return true;
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

        s1.contains(s2);

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)){

                }
            }
        }


        return -1;
    }


}
