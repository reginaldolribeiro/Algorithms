package algorithms.recursion;

public class Power {
    public static void main(String[] args) {
        int base = 2;
        int exponent = 4;
        System.out.println(base + " raised to the power of " + exponent + " is: " + power(base, exponent));
    }

    /**
     * Both implementations have the same time complexity of  O(exponent), but the iterative version
     * has better space complexity since it uses  O(1)  space compared to the recursive version’s  O(exponent).
     * Therefore, in terms of both time and space efficiency, the iterative version is better.
     *
     * @param base
     * @param exponent
     * @return
     */
    private static int power(int base, int exponent) {
        if(base == 0 && exponent == 0)
            throw new IllegalArgumentException("Base and exponent must not both be zero.");
        if(exponent == 0) return 1; // any number to the power of 0 is 1
        if(exponent == 1) return base;
        return base * power(base, exponent-1);
    }

    /**
     * Both implementations have the same time complexity of  O(exponent), but the iterative version
     * has better space complexity since it uses  O(1)  space compared to the recursive version’s  O(exponent).
     * Therefore, in terms of both time and space efficiency, the iterative version is better.
     *
     * @param base
     * @param exponent
     * @return
     */
    private static int power1(int base, int exponent) {
        if(base == 0 && exponent == 0)
            throw new IllegalArgumentException("Base and exponent must not both be zero.");
        if(exponent == 0) return 1; // any number to the power of 0 is 1
        if(exponent == 1) return base;

        int total = base;
        for (int i = 2; i <= exponent; i++) {
            total = total * base;
        }
        return total;
    }
}
