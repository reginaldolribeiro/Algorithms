package exercises.hackerrank;

import java.util.*;

public class CoinChangeProblem2 {
    public static void main(String[] args) {
        int change = 4;
        List<Long> numbers = Arrays.asList(1L,2L,3L);
//        int change = 7;
//        List<Long> numbers = Arrays.asList(3L,4L,5L,6L);
        long ways = getWays(change, numbers);
        System.out.println("CHanges: " + ways);
    }

    public static long getWays(int amount, List<Long> coins) {
        if (amount == 0) return 1;

        long[] changeWays = new long[amount + 1];
        changeWays[0] = 1; // (because there’s only 1 way to make 0 — by using no coins).

        for (int i = 0; i < coins.size(); i++) {
            int coin = coins.get(i).intValue();
            for (int j = coin; j <= amount; j++) {
                changeWays[j] = changeWays[j] + changeWays[j - coin];
            }
        }
        return changeWays[amount];
    }

//    public static long getWays(int amount, List<Long> c) {
//        if (amount == 0)
//            return 1;
//
//        long[] dp = new long[amount + 1];
//        dp[0] = 1; // (because there’s only 1 way to make 0 — by using no coins).
//
//        for (int i = 0; i < c.size(); i++) {
//            int coin = c.get(i).intValue();
//
//            for (int j = 1; j < dp.length; j++) {
//                if(j >= coin){
////                    dp[j] += dp[j - coin];
//                    dp[j] = dp[j] + dp[j - coin];
//                }
//            }
//        }
//        return dp[amount];
//    }


    /*public static long getWays(int amount, List<Long> c) {
        if (amount == 0)
            return 1; // Há exatamente uma maneira de fazer o total zero

        long[] dp = new long[amount + 1];
        dp[0] = 1; // Base do DP: uma maneira de formar o total 0

        for (int i = 0; i < c.size(); i++) {
            int coin = c.get(i).intValue();
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }*/




    // ****
    public static long getWays1(int amount, List<Long> c){
        if(amount == 0)
            return 0;

        int[] dp = new int[amount+1];
        dp[0] = 1; // (because there’s only 1 way to make 0 — by using no coins).
        for (int i = 1; i < dp.length; i++) {
            int count = 0;
            int tempAmount = i;
            int arrayIndex = 0;
            while(arrayIndex < c.size() && tempAmount >= c.get(arrayIndex)){
                int coin = Math.toIntExact(c.get(arrayIndex));
                if(tempAmount < coin)
                    continue;
                while(tempAmount >= coin){
                    if(tempAmount - coin >= 0){
                        tempAmount = tempAmount - coin;
                    }
                }
                if(tempAmount == 0){
                    count++;
                    tempAmount = i;
                }
                arrayIndex++;
            }
            dp[i] = count;

//            for (int j = 0; j < c.size(); j++) {
//                int coin = Math.toIntExact(c.get(j));
//                int tempAmount = i;
//                if(tempAmount < coin)
//                    continue;
//                while(tempAmount >= coin){
//                    if(tempAmount - coin >= 0){
//                        tempAmount = tempAmount - coin;
//                    }
//                }
//                if(tempAmount == 0){
//                    count++;
//                }
////                if(i > coin){
////                    if(i - coin > 0){
////
////                    }
////                }
////                if(i == coin){
////                    dp[i] = coin;
////                } else if(i >= coin && i - coin > 0){
////                    dp[i] = dp[j] + dp[i - coin];
////                }
//            }
//            dp[i] = count;
        }

        return dp[amount];
    }

}
