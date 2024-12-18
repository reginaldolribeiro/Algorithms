package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum2 {

    /**
     * Clarification Questions
     * 1. How should I handle with null or empty array? Should I do nothing or throw an error?
     * 2. Is this array always be sorted?
     * 3. Should I just print the min and max sum or should I return some value too?
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) throws IllegalAccessException {
//        List<Integer> arr = Arrays.asList(1,3,5,7,9);
        List<Integer> arr = Arrays.asList(3,1,5,9,7);
        minMaxSum(arr);
    }



    private static void minMaxSum(List<Integer> arr) throws IllegalAccessException {
        if(arr == null || arr.isEmpty())
            throw new IllegalArgumentException("Array must be filled with numbers.");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            Integer value = arr.get(i);
            sum += value;
            if(value < min){
                min = value;
            }
            if(value > max){
                max = value;
            }
        }

        long minSum = sum - max;
        long maxSum = sum - min;

        System.out.println(minSum + " " + maxSum);
    }



    /**
     * Assuming that this array always sorted in ascending order
     *
     * Big O Notation:
     *  - Time: O(n)
     *  - Space: O(1)
     *
     * @param arr
     * @throws IllegalAccessException
     */
    private static void minMaxSum1(List<Integer> arr) throws IllegalAccessException {
        if(arr == null || arr.isEmpty())
            throw new IllegalAccessException("Array must be filled with numbers.");

        int sum = 0;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            sum += arr.get(i);
        }
        int min = sum - arr.get(arr.size()-1); // O(1)
        int max = sum - arr.get(0); // O(1)

        System.out.println(min + " " + max);
    }
}
