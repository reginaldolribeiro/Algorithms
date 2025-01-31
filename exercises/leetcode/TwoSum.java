package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * A class demonstrating three solutions to the Two Sum problem:
 * - Optimized approach using a HashMap for O(n) time complexity.
 * - Brute force approach for educational purposes with O(n^2) time complexity.
 */
public class TwoSum {

    public static void main(String[] args) {
        // Example test cases
//        int[] arr = new int[]{1,4,3,2,7,8,10,5,20,15};
//        int[] arr = new int[]{4,-2,5,0,6,3,2,7};
//        int[] arr = new int[]{6,4,3,2};
//        int target = 7;

        int[] arr = new int[]{2,7,11,15};
        int target = 9;

        // Optimized approach
        int[] result = twoSum(arr, target);
        System.out.println((result.length > 0) ? ("Result: " + result[0] + ", " + result[1]) : "Not found");

        // Brute force approach
        int[] slowResult = twoSumSlow(arr, target);
        System.out.println((slowResult.length > 0) ? ("Slow Result: " + slowResult[0] + ", " + slowResult[1]) : "Not found");
    }

    /**
     * Finds two indices in the array such that the elements at those indices add up to the target.
     * This method uses a HashMap for an optimized O(n) solution.
     *
     * Validations:
     * - The input array must not be null or empty. An IllegalArgumentException is thrown if invalid.
     * - The target must not be zero. An IllegalArgumentException is thrown if invalid.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Single traversal of the array to find the result.
     * - Space Complexity: O(n) — HashMap to store complements and their indices.
     *
     * Steps:
     * 1. Validate the input:
     *    - Check if the array is null or empty.
     *    - Check if the target is zero.
     * 2. Traverse the array:
     *    - For each element, calculate its complement (target - current value).
     *    - Check if the current element exists as a key in the map.
     *    - If found, return the current index and the stored index of the complement.
     *    - If not found, store the complement in the map with its index.
     * 3. Return an empty array if no solution is found.
     *
     * @param nums   Input array of integers. Must not be null or empty.
     * @param target Target sum to find. Must not be zero.
     * @return An array containing two indices if a solution is found; otherwise, an empty array.
     * @throws IllegalArgumentException If the input array is null/empty or the target is zero.
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid array: Array must not be null or empty.");
        }
        if (target == 0) {
            throw new IllegalArgumentException("Invalid target: Target must not be zero.");
        }

        Map<Integer, Integer> complements = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null){
                return new int[]{i, complementIndex};
            } else {
                int complementValue = target - nums[i]; // Explicitly calculate the complement value
                complements.put(complementValue, i);   // Store the complement and its index
            }
        }
        return new int[]{}; // Return an empty array if no solution is found
    }

    /**
     * Finds two indices in the array such that the elements at those indices add up to the target.
     * This is a brute force solution for educational purposes.
     *
     * Big O Notation:
     * - Time Complexity: O(n^2) — Nested loops to check all pairs.
     * - Space Complexity: O(1) — No additional space is used.
     *
     * Steps:
     * 1. Use two nested loops to check all pairs in the array.
     * 2. If the sum of two elements matches the target, return their indices.
     *
     * @param nums   Input array of integers.
     * @param target Target sum to find.
     * @return An array of two indices if found; otherwise, an empty array.
     */
    public static int[] twoSumSlow(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // O(n)
            System.out.println("Outer Loop " + i);
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Inner Loop " + j);// O(n)
                int sum = nums[i] + nums[j];
                if(target == sum){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // Return empty array if no solution is found
    }

}
