package algorithms.sorting.september;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci1(9));
        System.out.println(fibonacci(9));
    }

    private static int fibonacci(int n){
        if(n <= 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int result = a + b;
            a = b;
            b = result;
        }
        return b;
    }
    // i=2, a=0, b=1, result=1, a=1, b=1
    // i=3, a=1, b=1, result=2, a=1, b=2
    // i=4, a=1, b=2, result=3, a=2, b=3
    // i=5, a=2, b=3, result=5, a=3, b=5

    private static int fibonacci1(int n){
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
