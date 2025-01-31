package exercises.leetcode;

/**
 * Moves all zeros in an array to the end while maintaining the relative order
 * of non-zero elements.
 *
 * Problem Example:
 * Input:  [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Solution:
 * - Use the two-pointer technique:
 *   1. If the array is null or has less than 2 elements, return immediately (no processing needed).
 *   2. Use `nonZeroIndex` to track the position to place the next non-zero element.
 *   3. Iterate through the array with a loop:
 *      - If a non-zero element is found, place it at `nonZeroIndex` and increment `nonZeroIndex`.
 *   4. After processing all elements, fill the rest of the array with zeros starting from `nonZeroIndex`.
 *
 * Big O Notation:
 * - Time Complexity: O(n) — Traverses the array twice (one loop for moving elements, one for filling zeros).
 * - Space Complexity: O(1) — In-place modification with constant extra space.
 *
 */
public class MoveZeros {
    public static void main(String[] args) {
        // Test case examples
        int[] nums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0}; // Test input
//        Result: 4 -> 2 -> 4 -> 3 -> 5 -> 1 -> 0 -> 0 -> 0 -> 0 ->

        // Call the function to move zeros
        moveZeros(nums);

        // Print the resulting array
        System.out.print("Result: ");
        for (int value : nums) {
            System.out.print(value + " -> ");
        }
    }

    /**
     * Moves all zeros to the end of the array while maintaining the relative order
     * of non-zero elements using the two-pointer technique.
     *
     * Steps:
     * 1. Traverse the array and move non-zero elements to the `nonZeroIndex` position.
     * 2. Fill the remaining positions in the array with zeros.
     *
     * @param nums The input array of integers.
     */
    private static void moveZeros(int[] nums) {
        // Step 1: Handle edge cases
        if (nums == null || nums.length <= 1) {
            return; // No action needed for null or single-element arrays
        }

        // Step 2: Initialize the pointer for non-zero elements
        int nonZeroIndex = 0;

        // Step 3: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, place it at the `nonZeroIndex`
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Step 4: Fill the remaining positions in the array with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
