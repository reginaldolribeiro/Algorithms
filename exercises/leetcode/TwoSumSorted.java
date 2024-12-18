package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSorted {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
//        int target = 18;
//        int target = 23;

        int[] result = twoSum(numbers, target);

        System.out.println((result.length > 0) ? ("Result " + result[0] + "," + result[1]) : "Not found");
    }

    /**
     * Big O notation
     *  Time: O(n)
     *  Space: O(1)
     *
     *  Two Sum Sorted
     *  Technique: Two-pointers
     *
     *  Use Two-Pointer Technique to iterate through the array summing the values of the pairs and comparing to the target.
     *  Pointers:
     *      - start = 0
     *      - end = numbers.size-1
     *  1. Sum numbers at position start and end:
     *      a. If the sum is greater than the target -> decrement "end"
     *      b. If the sum is smaller than the target -> increment start
     *  2. Base case
     *      a. The sum is the same value of the target
     *      b. The pointers "start" and "end" are equals.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("Numbers must not be null or empty.");

        if(numbers.length < 2)
            throw new IllegalArgumentException("Numbers must be at least 2 elements.");

        int start = 0;
        int end = numbers.length-1;

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum > target){
                end--;
            } else if(sum < target){
                start++;
            } else {
                return new int[]{start+1,end+1};
            }
        }

        return new int[]{};
    }

}
