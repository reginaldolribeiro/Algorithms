package algorithms.recursion;

import java.math.BigInteger;

public class TailRecursion {

    public static void main(String[] args) {
        System.out.println(factorialTailRecursion(5));
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
}
