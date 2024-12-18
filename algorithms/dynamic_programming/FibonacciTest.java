package algorithms.dynamic_programming;

public class FibonacciTest {
    public static void main(String[] args) {
        System.out.println(fibonacci(5  ));
    }

    // Save space complexity just using two simple variables
    public static int fibonacci(int n){
        if(n <=1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b; // n=2 -> 0 + 1 = 1, a=1, b=1 / n=3 -> 1+1=2, a=1, b=2, n=4 -> fb(3)+f(2)=3
            a = b;
            b = temp;
        }
        return b;
    }

    // Using extra space
    public static int fibonacci1(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
