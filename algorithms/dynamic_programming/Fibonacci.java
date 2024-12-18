package algorithms.dynamic_programming;

public class Fibonacci {

    // Example: Fibonacci de 4 - F(4)
    // ...
    // F(4) = F(3) + F(2) = 2 + 1 = 3
    // F(3) = F(2) + F(1) = 1 + 1 = 2
    // F(2) = F(1) + F(0) = 1 + 0 = 1
    // F(1) = 1
    // F(0) = 0

    public static void main(String[] args) {
        int n = 8;
//        int result = fibonacci(n);
        int result = fibonacciArray(n);
        int result1 = fibonacciMemo(n);
        System.out.println("Fibonacci of '" + n + "' is: " + result);
    }


    // Optimized avoiding use more memory, recursive and array.
    // Using just two variables to store the last sum of numbers
    private static int fibonacciMemo(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non-negative integer.");
        if(n <= 1) return n;

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
            System.out.println("F(" + i + ") is: " + b);
        }
        return b;
    }

    // Avoid call the same function multiple times, but still use more memory because of array of N
    private static int fibonacciArray(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non-negative integer.");
        if(n <= 1) return n;

        int[] fb = new int[n+1];
        fb[0] = 0;
        fb[1] = 1;

        for (int i = 2; i <= n; i++) {
            fb[i] = fb[i-1] + fb[i-2];
            System.out.println("F(" + i + ") is: " + fb[i]);
        }

        return fb[n];
    }

    // Recursive, more readable, but it costs more memory
    private static int fibonacci(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non-negative integer.");
        if(n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
