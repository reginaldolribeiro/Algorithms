package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,4,3,2,7,8,10,5,20,15};
        int[] arr = new int[]{4,-2,5,0,6,3,2,7};
//        int[] arr = new int[]{6,4,3,2};

        int[] result = twoSum(arr, 7);

        System.out.println((result.length > 0) ? ("Result " + result[0] + "," + result[1]) : "Not found");
    }

    /**
     * Big O notation
     *  time: O(n)
     *  space: O(n)
     *
     * Precisamos pegar o valor do target e subtrair do valor da nossa posicao atual.
     * Armazenar o resultado dessa subtracao e o indice num map, como abaixo
     * Map
     *  key = resultado subtracao
     *  valeu = index
     *
     *  Iterar sobre o array verificando se o numero atual esta contido na key do Map, se estiver, pegar o value (index) dele
     *  senao, devemos continuar subtraindo o target pelo valor posicao atual e tentando buscar no map
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null){
                return new int[]{i, complementIndex};
            } else {
                complements.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> complementToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            int complement = target - nums[i];
            if(complementToIndex.containsKey(nums[i])){
                return new int[]{i, complementToIndex.get(nums[i])};
            } else {
                complementToIndex.put(complement, i);
            }
        }
        return new int[]{};
    }

    /**
     * Brute force
     *
     * Big O notation
     *  time: O(n^2)
     *  space: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumSlow(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) { // O(n)
            System.out.println("Outer Loop " + i);
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("Inner Loop " + j);// O(n)
                int sum = nums[i] + nums[j];
                if(target == sum){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

}
