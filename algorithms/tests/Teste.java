package algorithms.tests;

public class Teste {
    public static void main(String[] args) {

        String originalString = "geeksforgeeks";
        char stringToCount = 'e';

        System.out.println("Original String: " + originalString);
        int result = countString(originalString, stringToCount);

        System.out.println("The quantity of letter " + stringToCount + " in " + originalString + " is " + result);
    }

    private static int countString(String originalString, char stringToCount) {

        long currentTimeMillis = System.nanoTime();

        int res = 0;

//        char[] charArray = originalString.toCharArray();
//        for (char c : charArray) {
//            if(c == stringToCount){
//                res++;
//            }
//        }

//        for(int i = 0; i < originalString.length()-1; i++){
//            if(originalString.charAt(i) == stringToCount){
//                res++;
//            }
//        }

        // Count returns number of occurrences of
        // c between two given positions provided
        // as two iterators.
//        System.out.println(Collections.frequency(
//                Arrays.asList(originalString.split("")),
//                String.valueOf(stringToCount)));

        long end = System.nanoTime();

        long total = end - currentTimeMillis;
        System.out.println("Duracao " + total);

        return res;
    }
}
