package exercises.leetcode;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        int result = climbStairs(n);
        System.out.println("There are " + result + " ways to climb to the top.");
    }

    public static int climbStairs(int n) {
        if(n <= 2)
            return n;

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * In how many distinct ways can you climb to the top?
     *
     * For 0 step = 0
     * For 1 step = 1
     * For 2 step = 2 -> 1+1, 2
     * For 3 step = 3 -> 1+1+1, 2+1, 1+2
     * For 4 step = 5 -> 1+1+1+1, 1+1+2, 1+2+1, 2+2, 2+1+1
     * For 5 step = 3 -> 1+1+1+1+1, 1+1+1+2, 1+2+2, 1+2+1+1, 1+1+2+1, 1+2+1+1
     * For 6 step = 4 -> 1+1+1+1+1+1, 1+1+1+1+2, 1+1+2+2, 2+2+2
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n <= 2)
            return n;

        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
