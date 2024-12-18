package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
//        int[] arr = new int[]{1,4,3,2,7,8,10,5,20,15};
//        int[] arr = new int[]{4,-2,5,0,6,3,2,7};
//        int[] arr = new int[]{6,4,3,2};
//        int target = 7;

        int[] result = twoSum(arr, target);

        System.out.println((result.length > 0) ? ("Result " + result[0] + "," + result[1]) : "Not found");
    }

    /**
     * More efficient
     *
     * While iterating through the array, we could:
     * 1. Subtract current number with target
     * 2. Put the remaining value as a key for a Map and the index as value Map<remaining, current index>
     * 3. Check if the current number is inside a map
     *  3.1 YES: return the value which is index and the index of the current number
     *
     * Big O Notation
     * - Time: O(n)
     * - Space: O(n)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int[] twoSum(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array must not be null or empty");

        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            Integer complementIndex = complements.get(value);
            if(complementIndex != null){
                return new int[]{i, complementIndex};
            } else {
                int complement = target - value;
                complements.put(complement, i);
            }
        }
        return new int[]{};
    }

    /**
     * Brute force - nested loops
     *
     * Big O Notation
     * - Time: O(n^2)
     * - Space: O(1)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array must not be null or empty");

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                int sum = value + arr[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }


}
