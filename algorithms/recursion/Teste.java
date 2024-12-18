package algorithms.recursion;

public class Teste {
    public static void main(String[] args) {
        int base = 2;
        int exponential = 3;
        int result = power(base, exponential);
        System.out.println(result);
    }

    private static int power(int base, int exponent) {
        // 2, 2 = 2 * 2 * 1 = 4
        // 2, 3 = 2 * 2 * 2 * 1 = 8
        // 2, 4 = 2 * 2 * 2 * 2 * 1 = 16

        if(exponent == 1) return base;

        return base * power(base, exponent - 1);
        // 2 * power(2, 1)
        // 4 * power
    }
}
