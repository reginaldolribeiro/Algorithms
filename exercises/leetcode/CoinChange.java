package exercises.leetcode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
//        int amount = 3;
//        int[] coins = {2};
//        int amount = 10;
//        int[] coins = {10};
        int usedCoins = change(amount, coins);
        System.out.println("--> The total of coins used to reach the amount " + amount + " is " + usedCoins);
    }

    // amount=5 / coins={1,2,5}
    // changeWays[0], changeWays[1], changeWays[2], changeWays[3], changeWays[4], changeWays[5]
    private static int change(int amount, int[] coins) {
        if(amount == 0)
            return 0;

        int[] changeWays = new int[amount+1];
        int impossibleValue = amount+1;
        Arrays.fill(changeWays, impossibleValue);
        changeWays[0] = 0;

        for (int i = 1; i < changeWays.length; i++) {
            for(int coin : coins){
                if(i >= coin){
                    int remaining = i - coin;
                    if(changeWays[remaining] < changeWays[i]){
                        changeWays[i] = 1 + changeWays[remaining];
                    }
                    // OR
//                    changeWays[i] = Math.min(changeWays[i], changeWays[remaining]+1)
                }
            }
        }
        if(changeWays[amount] == impossibleValue){
            return -1;
        } else {
            return changeWays[amount];
        }
    }
}
