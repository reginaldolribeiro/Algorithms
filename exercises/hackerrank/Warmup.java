package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Warmup {

    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(1,2,1,2,1,2,3);
//        List<Integer> arr = Arrays.asList(1,2,11,22,12,21,3);
//        int pairs = salesByMatch(arr);
//        System.out.println("Pairs: " + pairs);

//        staircase(5);
//        staircaseOptimized(5);

//        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        List<Integer> arr = Arrays.asList(2,1,4,5,3);
//        int total = arr.stream().mapToInt(n -> n).sum();
//        minMax1(arr);
        minMax(arr);

    }

    private static void minMax(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;

        for (Integer num : arr){
            total += num;
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }

        int minSum = total - max;
        int maxSum = total - min;

        System.out.println(minSum + " " + maxSum);
    }


    /**
     * If always the first element is the smaller and the last is the bigger, we can implement like this.
     *
     * @param arr
     */
    private static void minMax1(List<Integer> arr) {
        int total = 0;
        for (Integer n : arr){
            total += n;
        }
        int min = total - arr.get(arr.size()-1);
        int max = total - arr.get(0);
        System.out.println(min + " " + max);
    }

    /**
     * Big O Notation O(n^2)
     *
     * lines - i = quantity of spaces
     * i = quantity of hashes
     *
     * @param lines
     */
    private static void staircase(int lines){
        StringBuilder result = new StringBuilder();
        for(int i=1; i <= lines; i++){
            int quantityOfSpaces = lines - i; // numero de espacos a serem colocados
            for(int j=1; j <= lines; j++){
                if(j <= quantityOfSpaces){
                    result.append(" ");
                } else {
                    result.append("#");
                }
            }
            System.out.println(result);
            result.setLength(0);
        }
    }

    /**
     * Big O Notation
     *  time O(n)
     *  space O(n)
     *
     *  lines - i = quantity of spaces
     *  i = quantity of hashes
     *
     * @param lines
     */
    private static void staircaseOptimized(int lines) {
        for(int i=1; i <= lines; i++){
            String spaces = " ".repeat(lines - i);
            String hashes = "#".repeat(i);
            System.out.println(spaces + hashes);
        }
    }

    /*public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,1,2,1,2,3);
//        List<Integer> arr = Arrays.asList(1,2,11,22,12,21,3);
        int pairs = salesByMatch(arr);
        System.out.println("Pairs: " + pairs);
    }

    private static int salesByMatch(List<Integer> arr){
        Set<Integer> tempPairs = new HashSet<>();
        int pairs = 0;

        for(int i=0; i < arr.size(); i++){ // O(n)
            Integer value = arr.get(i);
            if(tempPairs.contains(value)){
                pairs++;
                tempPairs.remove(value);
            } else {
                tempPairs.add(value);
            }
        }

        return pairs;
    }*/
}
