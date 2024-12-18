package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

public class CoinChangeProblem3 {

    public static void main(String[] args) {
        int amount = 4;
        List<Long> numbers = Arrays.asList(1L,2L);
        long ways = getWays(amount, numbers);
        System.out.println("--> The total number of ways amount can be made for the amount " + amount + " is " + ways);
    }

    /**
     * Criar um array com o tamanho do amount+1 para que possa ter valor de troco de 0 ate o amount
     * A maneira de dar troco para 0 reais é nao dando nenhum troco, ou seja, uma maneira
     * dp[0] = 1
     *
     * Iterar sobre este array
     *
     * coins = [1,2], amount = 4
     *
     * @param amount
     * @param coins
     * @return
     */
    public static long getWays(int amount, List<Long> coins) {
        int[] changeWays = new int[amount+1];
        changeWays[0] = 1;

        for (int i = 0; i < coins.size(); i++) {
            int coin = coins.get(i).intValue();
            for (int j = coin; j <= amount; j++) {
                changeWays[j] = changeWays[j] + changeWays[j - coin];
            }
        }

        return changeWays[amount];
    }


}
