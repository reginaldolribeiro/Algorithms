package exercises.leetcode;

public class SingleNumber {

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Example 1:
     *  Input: nums = [2,2,1]
     *  Output: 1
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};

        /*int result = 2^2;
        System.out.println("XOR " + result);
        System.out.println("XOR " + (2^1));
        System.out.println("XOR " + (2^1));*/

        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }

    /**
     * A operação XOR é amplamente utilizada em algoritmos e programação devido às suas propriedades únicas.
     * Um uso comum é encontrar um único número em uma lista onde todos os outros números aparecem duas vezes.
     * Usando XOR, você pode cancelar pares de números iguais e obter o número que aparece uma vez:
     *
     * Neste algoritmo, todos os números que aparecem em pares serão cancelados (num ^ num = 0),
     * deixando apenas o número que aparece uma vez no resultado final.
     *
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
