package exercises;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int change = 10;
        int[] coins = {1,5,10};
        int ways = coinChange(coins, change);
        System.out.println("CHanges: " + ways);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] changeWays = new int[amount+1];
        changeWays[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j < changeWays.length; j++) {
                if(j >= coin){
                    changeWays[j] = changeWays[j] + changeWays[j - coin];
                }
            }
        }

        return changeWays[amount];
    }

}
