package exercises.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChangeProblemOld {

//    public static void main(String[] args) {
//        int[] numbers = {1,2,3,4};
//        int result = soma(numbers, 0);
//        System.out.println("Soma: " + result);
//    }
//
//
//    public static int soma(int[] nums, int index) {
//        if (index == nums.length) {  // Caso base: se o índice chegou ao fim do array
//            return 0;
//        } else {
//            return nums[index] + soma(nums, index + 1);  // Soma o número atual com o restante da lista
//        }
//    }

//    public static void main(String[] args) {
//        int change = 4;
//        List<Long> numbers = Arrays.asList(1L,2L,3L);
////        long ways = getWays(change, numbers);
////        System.out.println("CHanges: " + ways);
//
//        int changes = test(change, 1);
//        System.out.println(changes);
//    }

    public static int test(int amount, int value){
        if(amount == 0)
            return 0;
        return amount - test(amount-value, value);
    }

    // change >= numbers[i], se nao for maior, passa para o proximo elemento
    // Se for maior, (change - numbers[i])
    // while loop enquanto change - elemento nao for 0, continua subtraindo e guardando este valor num array
    // {1,1,1,1}
    //
    // {2,2}
    // {3,
//    public static long getWays(int amount, List<Long> c){
//        if(amount == 0)
//            return 0;
//
//        Map<Integer, List<Long>> coins = new HashMap<>();
//        long ways = 0;
//        int count = 1;
//
//        for(Long coin : c){
//            if(amount >= coin) {
//                long diff = amount;
////                if (diff >= 0 && diff - coin >= 0) {
////                    diff = diff - coin;
////                }
//                diff = helper(diff, coin);
//            }
//        };
//        return ways;
//    }
//
//    private static long helper(long diff, Long coin) {
//        if(diff == 0)
//            return diff;
//
//        if(diff - coin >= 0){
//            diff = diff - coin;
//            return helper(diff, coin);
//        }
//
//        return -1;
//    }


    /**
     * 1. Percorrer o array de moedas e:
     * 2. Checar se o valor da moeda é MENOR ou igual ao amount
     *  2.1 Se SIM:
     *      -> Subtrair o amount do valor da moeda (amount - coin) ate que o amount seja ZERO
     *      -> Armazenar as moedas num array temporario so para printar
     *  2.2 Se NAO, passar para a proxima moeda do array
     *
     *
     *
     * @param amount
     * @param c
     * @return
     */
    public static long getWays(int amount, List<Long> c){
        if(amount == 0)
            return 0;

        Map<Integer, List<Long>> coins = new HashMap<>();
        long ways = 0;
        int count = 1;

        for (int i = 0; i < c.size(); i++) {
            long diff = amount;
            Long coin = c.get(i);
            List<Long> coinList = new ArrayList<>();
            if(coin <= diff) {
                while (diff >= 0 && diff - coin >= 0) {
                    diff = diff - coin;
                    coinList = coins.getOrDefault(count, new ArrayList<Long>());
                    coinList.add(coin);
//                    coins.put(count, coinList);
                }
                count++;
                if(diff == 0) {
                    ways++;
                    coins.put(count, coinList);
                }
                for (int j = 1; j < c.size(); j++) {
                    Long secondCoin = c.get(j);
                    coinList = new ArrayList<>();
                    if(coin <= secondCoin){
                        diff = amount;
                        if(diff >= 0 && diff - secondCoin >= 0){
                            count++;
                            diff = diff - secondCoin;
                            coinList = coins.getOrDefault(count, new ArrayList<Long>());
                            coinList.add(coin);
                            coins.put(count, coinList);
                        }
                    }

                }
                if(diff == 0) {
                    ways++;
                }
            }
        };
        return ways;
    }

//    public static int getWaysHelper(int n, Long value){
//        if(n == 0) return 0;
//        while (n - value >= 0) {
//            n = (int) (n - value);
//        }
//    }
}
