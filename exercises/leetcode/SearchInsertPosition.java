package exercises.leetcode;

/**
 * A class demonstrating the solution to the "Search Insert Position" problem using binary search.
 *
 * Problem Description:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * Example:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Big O Notation:
 * - Time Complexity: O(log n) — Binary search is used to locate the target or determine the insertion point.
 * - Space Complexity: O(1) — No extra space is used apart from variables.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        // Test cases
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7; // Expected output: 4 (position to insert)

        // Execute the searchInsert method and print the result
        int result = searchInsert(nums, target);
        System.out.println("Result = " + result);
    }

    /**
     * Finds the target index or the position where the target should be inserted in a sorted array.
     * This method uses binary search for efficient computation.
     *
     * Algorithm:
     * 1. Initialize two pointers: `start` (beginning of the array) and `end` (end of the array).
     * 2. Use a `while` loop to continue the search while `start` is less than or equal to `end`.
     * 3. Calculate the middle index of the array.
     * 4. Compare the middle element with the target:
     *    - If the target is greater than the middle element, move the `start` pointer to `middle + 1`.
     *    - If the target is less than the middle element, move the `end` pointer to `middle - 1`.
     *    - If the target matches the middle element, return the middle index.
     * 5. If the target is not found, return the `start` pointer as the insertion position.
     *
     * Big O Notation:
     * - Time Complexity: O(log n) — Efficient binary search to locate the target or insertion point.
     * - Space Complexity: O(1) — Only pointers and variables are used.
     *
     * @param nums   The sorted array of integers.
     * @param target The target integer to find or insert.
     * @return The index of the target or the insertion position.
     */
    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // Binary search loop
        while (start <= end) {
            int middle = start + (end - start) / 2; // Avoid overflow in case of large arrays
            int value = nums[middle];

            // Debugging output (optional for understanding steps)
            System.out.println("middle " + middle);

            // Adjust the search range based on comparison
            if (target > value) {
                start = middle + 1;
            } else if (target < value) {
                end = middle - 1;
            } else {
                System.out.println("Found our index " + middle + " for the element " + value);
                return middle; // Target found
            }
        }

        // Return the insertion position if the target is not found
        return start;
    }
}