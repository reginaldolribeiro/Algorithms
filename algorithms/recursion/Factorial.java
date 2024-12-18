package algorithms.recursion;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
//        int n = 1;
//        int factorial = factorialInt(n);
//        long n = 1;
//        long factorial = factorialLong(n);

        int n = 500;
        BigInteger factorial = factorialTailRecursion(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }


    private static long factorialLong(long n){
        if(n <= 1) return 1;
        System.out.println("Computing factorial of " + n + " - I first need factorial of " + (n-1));
        long factorial = n * factorialLong(n-1);
        System.out.println("Computed factorial of " + n);
        return factorial;
    }

    private static int factorialInt(int n){
        if(n <= 1) return 1;
        System.out.println("Computing factorial of " + n + " - I first need factorial of " + (n-1));
        int factorial = n * factorialInt(n-1);
        System.out.println("Computed factorial of " + n);
        return factorial;
    }

    /**
     * Using Tail Recursion
     *
     * @param n
     * @return
     */
    private static BigInteger factorialTailRecursion(int n){
        return factorialHelper(n, BigInteger.ONE);
    }

    private static BigInteger factorialHelper(int x, BigInteger accumulator){
        if(x <= 1) return accumulator;
        return factorialHelper(x-1, accumulator.multiply(BigInteger.valueOf(x)));
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
    public static int factorialIterative(int n){
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

}
