package exercises.leetcode;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
//        int amount = 3;
//        int[] coins = {2};
//        int amount = 10;
//        int[] coins = {10};
        int ways = change(amount, coins);
        System.out.println("--> The total number of ways amount can be made for the amount " + amount + " is " + ways);
    }

    /**
     * LeetCode - Coin Change 2
     * https://leetcode.com/problems/coin-change-ii/description/
     *
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money.
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up
     * by any combination of the coins, return 0.
     * You may assume that you have an infinite number of each kind of coin.
     * The answer is guaranteed to fit into a signed 32-bit integer.
     *
     * Big O Notation:
     *	• Time Complexity: O(m × n)
     * 	•	m = Number of coin denominations (coins.length).
     * 	•	n = Target amount (amount).
     * 	•	The nested loops result in a multiplication of the two variables.
     * 	• Space Complexity: O(n)
     * 	•	You use an array changeWays of size amount + 1.
     *
     * @param amount
     * @param coins
     * @return
     */
    private static int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;

        int[] changeWays = new int[amount+1];
        changeWays[0] = 1;

        for(int coin : coins){
            for (int i = 1; i < changeWays.length; i++) {
                if(i >= coin){
                    changeWays[i] = changeWays[i] + changeWays[i - coin];
                    System.out.println("changeWays[" + i + "] + changeWays[" + i + " - " + coin + "] -> " + "changeWays[" + i + "] = " + changeWays[i]);
                }
            }
        }

        return changeWays[amount];
    }
}
