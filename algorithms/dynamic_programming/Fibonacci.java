package algorithms.dynamic_programming;

/**
 * A class demonstrating three methods to compute the Fibonacci sequence:
 * - Recursive: Simplest but inefficient due to repeated computations.
 * - Dynamic Programming (DP): Optimized to avoid repeated computations but uses additional memory.
 * - Iterative (Memoization): Most efficient, with constant space complexity.
 *
 * Example:
 * Fibonacci Sequence: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
 *
 * For n = 4:
 * F(4) = F(3) + F(2) = 3
 * F(3) = F(2) + F(1) = 2
 * F(2) = F(1) + F(0) = 1
 * F(1) = 1
 * F(0) = 0
 *
 * Big O Notation:
 * - Recursive: O(2^n) time, O(n) space (call stack).
 * - DP: O(n) time, O(n) space (array for storage).
 * - Memoization: O(n) time, O(1) space (constant space).
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 8; // Compute Fibonacci of 8

        // Call the three different methods and print the results
        System.out.println("Fibonacci of '" + n + "' using Recursive: " + fibonacci(n));
        System.out.println("Fibonacci of '" + n + "' using Dynamic Programming: " + fibonacciDp(n));
        System.out.println("Fibonacci of '" + n + "' using Memoization: " + fibonacciMemo(n));
    }

    /**
     * Computes the Fibonacci number using recursion.
     *
     * Algorithm:
     * - If n <= 1, return n (base cases).
     * - Otherwise, recursively compute F(n-1) + F(n-2).
     *
     * Big O Notation:
     * - Time Complexity: O(2^n) — Exponential growth due to repeated computations.
     * - Space Complexity: O(n) — Call stack space for recursion.
     *
     * @param n The index in the Fibonacci sequence.
     * @return The Fibonacci number at index n.
     */
    private static int fibonacci(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be a non-negative integer.");
        if (n <= 1)
            return n; // Base cases: F(0) = 0, F(1) = 1

        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }

    /**
     * Computes the Fibonacci number using Dynamic Programming.
     *
     * Algorithm:
     * - Use an array to store Fibonacci numbers up to n.
     * - F(0) = 0, F(1) = 1.
     * - Iteratively compute F(i) = F(i-1) + F(i-2) for i >= 2.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each Fibonacci number is computed once.
     * - Space Complexity: O(n) — Array of size n+1 is used.
     *
     * @param n The index in the Fibonacci sequence.
     * @return The Fibonacci number at index n.
     */
    private static int fibonacciDp(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be a non-negative integer.");
        if (n <= 1) return n; // Base cases

        int[] fb = new int[n + 1]; // Array to store Fibonacci numbers
        fb[0] = 0;
        fb[1] = 1;

        for (int i = 2; i <= n; i++) {
            fb[i] = fb[i - 1] + fb[i - 2]; // DP formula
            System.out.println("F(" + i + ") is: " + fb[i]); // Debugging output
        }

        return fb[n]; // Return the nth Fibonacci number
    }

    /**
     * Calculates the nth Fibonacci number using memoization with variables `previous` and `current`
     * for better readability.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each Fibonacci number from 0 to n is calculated once.
     * - Space Complexity: O(1) — Only constant space is used for variables.
     *
     * @param n The position in the Fibonacci sequence to calculate.
     * @return The nth Fibonacci number.
     */
    public static int fibonacciMemo(int n) {
        if (n <= 0) {
            return 0; // Edge case: Fibonacci(0) is 0
        }
        if (n == 1) {
            return 1; // Edge case: Fibonacci(1) is 1
        }

        // Initialize variables to store previous and current Fibonacci numbers
        int previous = 0; // Fibonacci(0)
        int current = 1;  // Fibonacci(1)

        // Loop to calculate Fibonacci numbers up to n
        for (int i = 2; i <= n; i++) {
            int next = previous + current; // Calculate the next Fibonacci number
            previous = current;           // Update `previous` to the current value
            current = next;               // Update `current` to the next value
            System.out.println("F(" + i + ") is: " + current); // Debugging output
        }

        return current; // Return the nth Fibonacci number
    }
}