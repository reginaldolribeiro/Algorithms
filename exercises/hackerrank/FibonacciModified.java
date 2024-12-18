package exercises.hackerrank;

import java.math.BigInteger;

public class FibonacciModified {
    public static void main(String[] args) {
        int t1 = 0;
        int t2 = 1;
        int n = 10;
        int result = fibonacciModified(t1,t2,n);
        System.out.println(result);
    }

    public static int fibonacciModified(int t1, int t2, int n){
        if(n <= 0)
            return 0;
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        for (int i = 3; i <= n; i++) {
            BigInteger temp = a.add(b.multiply(b));
            a = b;
            b = temp;
        }

        if (b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new ArithmeticException("Result exceeds the range of int.");
        }

        return b.intValue();
    }

    public static BigInteger fibonacciModified1(int t1, int t2, int n) {
        // Initialize a and b as BigInteger to handle large values
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);

        for (int i = 3; i <= n; i++) {
            // Calculate the next term as a + (b * b)
            BigInteger temp = a.add(b.multiply(b));
            a = b;
            b = temp;
        }

        // Return the nth term as a BigInteger
        return b;
    }

    public static BigInteger fibonacciModified2(int t1, int t2, int n){
        if(n <= 0)
            return BigInteger.ZERO;
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        for (int i = 3; i <= n; i++) {
            BigInteger temp = a.add(b.multiply(b));
            a = b;
            b = temp;
        }
        return b;
    }
}
