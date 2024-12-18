package algorithms.dynamic_programming;

public class Knapsack {

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        System.out.println("Maximum value in knapsack: " + knapsack(values, weights, capacity));
    }

    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]); // maximum number between them
            }
        }
        return dp[capacity];
    }

}
