package exercises.hackerrank;

import java.util.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
//        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L, 5L);
//        List<Integer> numbers = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
//        miniMaxSumInteger(numbers);

//        List<Integer> numbers = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum1(numbers);
//        miniMaxSum(numbers);
//        miniMaxGpt(numbers);
//        miniMaxSumGptOriginal(numbers);
    }


    public static void miniMaxSum1(List<Integer> arr){
        long total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            total += arr.get(i);
            if(arr.get(i) < min){
                min = arr.get(i);
            }
            if(arr.get(i) > max){
                max = arr.get(i);
            }
        }

        long minValue = total - max;
        long maxValue = total - min;

        System.out.println(minValue + " " + maxValue);
    }

    /**
     * Most efficient implementation
     *
     * Time Complexity: O(n), where n is the size of the list. The list is traversed once.
     * Space Complexity: O(1), as only a few extra variables are used.
     *
     * @param arr
     */
    private static void minMax(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;

        for (int num : arr) {
            total += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        int minSum = total - max;
        int maxSum = total - min;

        System.out.println(minSum + " " + maxSum);
    }

    /**
     * Efficient approach
     *
     * Compute the total sum once (first loop) and then subtract each element to get the sum of n-1 elements (second loop)
     *
     * Big O Notation
     *  Time complexity O(n)
     *  Space complexity O(1) because we have only a few extra variables (totalSum, minSum, maxSum)
     *
     * @param arr
     */
    private static void miniMaxGpt(List<Integer> arr){
        long totalSum = 0;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            totalSum += arr.get(i);
        }

        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) { // O(n)
            long currentSum = totalSum - arr.get(i);
            if(currentSum < minSum){
                minSum = currentSum;
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    /**
     * Iterate through an array, summing each number except the one at the current position.
     * Finally, determine the minimum and maximum values among the calculated sums.
     *
     * Big O Notation
     *  Time complexity O(n^2)
     *  Space complexity O(n) because auxiliary Array (calculatedNumbers) store n elements
     *
     * @param arr
     */
    private static void miniMaxSum(List<Integer> arr) {
        List<Long> calculatedNumbers = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) { // O(n)
            long sum = 0;
            for (int j = 0; j < arr.size(); j++) { // O(n)
                if(i != j){
                    sum += arr.get(j);
                }
            }
            calculatedNumbers.add(sum);
        }

        Long min = calculatedNumbers // O(n)
                .stream()
                .min(Comparator.comparingLong(value -> value))
                .orElse(Long.MIN_VALUE);
        Long max = calculatedNumbers // O(n)
                .stream()
                .max(Comparator.comparingLong(value -> value))
                .orElse(Long.MIN_VALUE);

        System.out.println(min + " " + max);
    }

    /**
     * Efficient approach
     *
     * Compute the total sum once (first loop) and then subtract each element to get the sum of n-1 elements (second loop)
     *
     * Big O Notation
     *  Time complexity O(n)
     *  Space complexity O(1) because we have only a few extra variables (totalSum, minSum, maxSum)
     *
     * @param arr
     */
    private static void miniMaxSumGptOriginal(List<Integer> arr) {
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        for (int num : arr) {
            long currentSum = totalSum - num;
            if (currentSum < minSum) {
                minSum = currentSum;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println(minSum + " " + maxSum);
    }

    /**
     * Iterate through an array, summing each number except the one at the current position.
     * Finally, determine the minimum and maximum values among the calculated sums.
     *
     * @param arr
     */
    private static void miniMaxSumInteger(List<Integer> arr) {
        List<Integer> calculatedNumbers = new ArrayList<Integer>();

        for (int i = 0; i < arr.size(); i++) {
            int sum = 0;
            for (int j = 0; j < arr.size(); j++) {
                if(i != j){
                    sum += arr.get(j);
                }
            }
            calculatedNumbers.add(sum);
        }

        Integer min = calculatedNumbers
                .stream()
                .min(Comparator.comparingInt(value -> value))
                .orElse(-1);
        Integer max = calculatedNumbers
                .stream()
                .max(Comparator.comparingInt(value -> value))
                .orElse(-1);

        System.out.println(min + " " + max);
    }


}
