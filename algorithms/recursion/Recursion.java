package algorithms.recursion;

public class Recursion {

    // recursion = When a thing is defined in terms of itself. - Wikipedia
    //              Apply the result of a procedure, to a procedure.
    //              A recursive method calls itself. Can be a substitute for iteration.
    //              Divide a problem into sub-problems of the same type as the original.
    //              Commonly used with advanced sorting algorithms and navigating trees
    //
    //            Advantages
    //              - easier to read/write
    //              - easier to debug
    //            Disadvantages
    //              - sometimes slower
    //              - uses more memory

    public static void main(String[] args) {
//        int n = 2;
//        System.out.println("Factorial of " + n + " is: " + factorial(n));
//
//        System.out.println("\n...Walking iterative...\n");
//        walkIteration(n);
//
//        System.out.println("\n...Walking recursively...\n");
//        walkRecursion(n);

        System.out.println("\n...Power...\n");
        int power = power(2, 3);
        System.out.println("Power " + power);
    }

    /**
     * Exponentiation (like 2^4) 2 raised to the power of 4 means multiplying a number by itself a certain number of times.
     * 2^4 = 2 raised to the power of 4
     * For example:
     *  2^3 = 2 * 2 * 2 = 8
     *  2^4 = 2 * 2 * 2 * 2 = 16
     *
     *
     * @param base
     * @param exponent
     * @return
     */
    private static int power(int base, int exponent){
        if(exponent == 1) // base case
            return base;
        return base * power(base, exponent-1); // recursive case
    }

    /**
     * Factorial, denoted by n!, means multiplying a number by all the positive integers less than it.
     * For example, 4! (4 factorial) is:
     *  4! = 4 * 3 * 2 * 1 = 24
     *
     * @param n
     * @return
     */
        public static int factorial(int n){
            if(n <= 1) return 1; // base case
            return n * factorial(n-1); // recursive case
        }

    public static void walkIteration(int steps){
        for (int i = 0; i < steps; i++) {
            System.out.println("You take a step!");
        }
    }

    public static void walkRecursion(int steps){
        if(steps < 1) return; // base case
        System.out.println("You take a step!");
        walkRecursion(steps-1); // recursive case
    }

}
