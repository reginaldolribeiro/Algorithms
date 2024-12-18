package exercises;

public class Factorial {
    public static void main(String[] args) {
        int n = 3;
        int result = factorial(n);
        System.out.println("F(" + n + ")! = " + result);
    }

    /**
     * Using Iterative Approach
     *
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * @param n
     * @return
     */
    public static int factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        // base case
        if(n<=1) return 1;

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = i * result;
        }

        return result;
    }

    /**
     * Using Recursion
     *
     * Big O Notation
     *  Time: O(n)
     *  Space: O(n)
     *
     * @param n
     * @return
     */
    public static int factorial2(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if(n<=1)
            return 1; // base case
        return n * factorial(n-1);
    }
}
