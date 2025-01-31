package algorithms.dynamic_programming;

/**
 * A class that solves the 0/1 Knapsack problem using dynamic programming.
 *
 * Problem Description:
 * Given weights and values of n items, determine the maximum value that can
 * be put in a knapsack of capacity W such that the total weight of selected
 * items does not exceed the capacity.
 *
 * Example:
 * Values:  [60, 100, 120]
 * Weights: [10,  20,  30]
 * Capacity: 50
 * Output: Maximum value in knapsack: 220
 *
 * Big O Notation:
 * - Time Complexity: O(n * capacity) — Each item is iterated through the capacity range.
 * - Space Complexity: O(capacity) — Uses a 1D array of size equal to the capacity.
 */
public class Knapsack {

    public static void main(String[] args) {
        // Example input
        int[] values = {60, 100, 120};   // Values of the items
        int[] weights = {10, 20, 30};   // Weights of the items
        int capacity = 50;              // Knapsack capacity

        // Output the maximum value that can fit in the knapsack
        System.out.println("Maximum value in knapsack: " + knapsack(values, weights, capacity));
    }

    /**
     * Solves the 0/1 Knapsack problem using dynamic programming.
     *
     * Algorithm:
     * 1. Use a 1D DP array `dp` where `dp[w]` represents the maximum value
     *    that can be achieved with a knapsack capacity of `w`.
     * 2. Iterate over each item:
     *    - For each item's weight, update the DP array from `capacity` down to the item's weight.
     *    - Use the formula `dp[w] = max(dp[w], dp[w - weight[i]] + value[i])`.
     * 3. Return the value at `dp[capacity]`, which contains the maximum value for the given capacity.
     *
     * Big O Notation:
     * - Time Complexity: O(n * capacity) — Iterates through all items and capacities.
     * - Space Complexity: O(capacity) — Only a single DP array of size `capacity` is used.
     *
     * @param values   Array of values of the items.
     * @param weights  Array of weights of the items.
     * @param capacity The total capacity of the knapsack.
     * @return The maximum value that can fit in the knapsack.
     */
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;          // Number of items
        int[] dp = new int[capacity + 1]; // DP array to store maximum values for capacities

        // Iterate through all items
        for (int i = 0; i < n; i++) {
            // Update the DP array from capacity down to the item's weight
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]); // Choose the max value
            }
        }

        // Return the maximum value for the given capacity
        return dp[capacity];
    }
}