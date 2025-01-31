package algorithms.search;

/**
 * A class demonstrating Binary Search to find the index of a target element in a sorted array.
 *
 * Problem Description:
 * Given a sorted array and a target element, return the index of the target if found.
 * If not found, return -1.
 *
 * Example:
 * Input: array = {1, 2, 3, 4, 5, 6, 7, 8, 9}, target = 5
 * Output: 4 (index of 5)
 *
 * Big O Notation:
 * - Time Complexity: O(log n) — The array is divided in half at each step.
 * - Space Complexity: O(1) — No additional space is used.
 */
public class BinarySearch {

    public static void main(String[] args) {
        // Example test case: small array
        System.out.println("*** Small Array ***");
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int target1 = 8;

        // Perform Binary Search
        int index1 = binarySearch(array1, target1);

        // Print the result
        if (index1 != -1) {
            System.out.println("Element found at index " + index1);
        } else {
            System.out.println("Element not found!");
        }

        // Example test case: Large array
        System.out.println("\n*** LARGE Array ***");
        int[] array = new int[1_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i; // Populate array with sorted integers from 0 to 999,999
        }
        int target = 777777; // Target value to search for

        // Perform Binary Search
        int index = binarySearch(array, target);

        // Print the result
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found!");
        }
    }

    /**
     * Performs Binary Search on a sorted array to find the target element.
     *
     * Algorithm:
     * 1. Initialize two pointers: `low` (start of the array) and `high` (end of the array).
     * 2. While `low` is less than or equal to `high`:
     *    - Calculate the middle index of the current range.
     *    - Compare the middle element with the target:
     *      - If the target is less than the middle element, search the left half (`high = middle - 1`).
     *      - If the target is greater than the middle element, search the right half (`low = middle + 1`).
     *      - If the target equals the middle element, return the index.
     * 3. If the target is not found, return -1.
     *
     * Big O Notation:
     * - Time Complexity: O(log n) — Halves the search space at each step.
     * - Space Complexity: O(1) — Only uses constant space for pointers and variables.
     *
     * @param array  The sorted array to search.
     * @param target The target value to find.
     * @return The index of the target element, or -1 if not found.
     */
    private static int binarySearch(int[] array, int target) {
        int low = 0; // Start of the array
        int high = array.length - 1; // End of the array

        // Perform Binary Search
        while (low <= high) {
            int middle = low + (high - low) / 2; // Calculate the middle index
            int value = array[middle];

            System.out.println("Checking middle index " + middle + " with value " + value);

            // Adjust the search range based on comparison
            if (target < value) {
                high = middle - 1; // Search in the left half
            } else if (target > value) {
                low = middle + 1; // Search in the right half
            } else {
                return middle; // Target found
            }
        }

        return -1; // Target not found
    }
}