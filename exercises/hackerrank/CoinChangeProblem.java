package exercises.hackerrank;

import java.util.*;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int amount = 5;
        List<Long> numbers = Arrays.asList(1L,2L,3L);
//        int amount = 7;
//        List<Long> numbers = Arrays.asList(3L,4L,5L,6L);
        long ways = getWays(amount, numbers);
        System.out.println("--> The total number of ways amount can be made for the amount " + amount + " is " + ways);
    }

    /**
     * Hackerrank - The Coin Change Problem
     * <a href="https://www.hackerrank.com/challenges/coin-change/problem">...</a>
     *
     * Definition:
     *  Given an amount and the denominations of coins available, determine how many ways change can be made for amount.
     *  There is a limitless supply of each coin type.
     *
     * Solution:
     *
     *  Solving using Dynamic Programming is the best approach in terms of efficiency
     *
     *  Big O Notation
     *      Time Complexity: O(m × n), where m is the number of coin denominations and n is the target amount.
     *      Space Complexity: O(n), due to the array used to store the number of ways for each amount up to n.
     *
     *  Purpose:
     *      Use an array to accumulate the number of ways to make change for each amount,
     *      building up from smaller amounts to larger ones.
     *
     *  Process:
     * 	    • Initialize the array with zeros and set array[0] = 1 (there is one way to make change for amount zero).
     * 	    • For each coin, update the array using the formula array[i] += array[i - coin].
     *
     *  Result:
     *      The array will contain the number of ways to make change for each amount up to the target amount.
     *
     * @param amount
     * @param coins
     * @return The total number of ways change can be made for the amount.
     */
    public static long getWays(int amount, List<Long> coins) {

        // Base case: There is 1 way to make change for amount 0 (using no coins)
        if (amount == 0)
            return 1;

        // Initialize an array to store the number of ways to make change for each amount up to 'amount'
        long[] changeWays = new long[amount + 1];
        changeWays[0] = 1; // Base case: There is 1 way to make change for amount 0 (using no coins)

        // Loop through each coin denomination
        for (int i = 0; i < coins.size(); i++) {
            int coin = coins.get(i).intValue();

            // For each amount from the value of 'coin' up to 'amount'
            // changeWays[j] = changeWays[j] + changeWays[j - coin];
            // changeWays[1] = changeWays[1] + changeWays[1 - 1] = 1
            // changeWays[2] = changeWays[2] + changeWays[2 - 1] = 1
            // changeWays[3] = changeWays[3] + changeWays[3 - 1] = 1;
            // changeWays[4] = changeWays[4] + changeWays[4 - 1] = 1;

            // changeWays[2] = changeWays[2] + changeWays[2 - 1] = 2;
            // changeWays[3] = changeWays[3] + changeWays[3 - 1] = 2;
            // changeWays[4] = changeWays[4] + changeWays[4 - 1] = 3;


            for (int j = coin; j <= amount; j++) {
                // Update changeWays[j] by adding the number of ways to make change for (j - coin)
                changeWays[j] = changeWays[j] + changeWays[j - coin];
                System.out.println("changeWays[" + j + "] + changeWays[" + j + " - " + coin + "] -> " + "changeWays[" + j + "] = " + changeWays[j]);
                /*
                 * Explanation:
                 * - changeWays[j - coin] is the number of ways to make change for the amount (j - coin).
                 * - By adding changeWays[j - coin] to changeWays[i], we include the combinations that use the current coin.
                 * - This effectively counts all new ways to form amount 'j' by adding the current coin to
                 *   the ways we can form amount 'j - coin'.
                 */
            }
        }

        // Return the total number of ways to make change for the target amount
        return changeWays[amount];
    }

    /**
     *
     */
    public static long getWays1(int amount, List<Long> c) {
        if (amount == 0)
            return 1;

        long[] dp = new long[amount + 1];
        dp[0] = 1; // (because there’s only 1 way to make 0 — by using no coins).

        for (int i = 0; i < c.size(); i++) {
            int coin = c.get(i).intValue();

            for (int j = 1; j < dp.length; j++) {
                if(j >= coin){
//                    dp[j] += dp[j - coin];
                    dp[j] = dp[j] + dp[j - coin];
                    System.out.println("dp[" + j + "] + dp[" + j + " - " + coin + "] = " + dp[j]);
                }
            }
        }
        return dp[amount];
    }

}
