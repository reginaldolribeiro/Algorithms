package algorithms.sorting.september;

import java.util.HashSet;
import java.util.Set;

public class CountDuplicate {
    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
        int[] nums = {3,1,20,3,4};
//        int[] nums = {};
        for(int n : nums){
            System.out.print(n + " ");
        }
        int result = countDuplicates(nums);
        System.out.println("\nResult: " + result);
    }

    private static int countDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> temp = new HashSet<>();
        int duplicates = 0;
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                duplicates++;
            }else{
                temp.add(nums[i]);
            }
        }
        return duplicates;
    }

//    public static int countDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int duplicateCount = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int index = Math.abs(nums[i]);  // Use the absolute value of nums[i] as an index
//            if (nums[index] < 0) {
//                // If the value at nums[index] is already negative, it's a duplicate
//                duplicateCount++;
//            } else {
//                // Otherwise, negate the value at that index to mark it as visited
//                nums[index] = -nums[index];
//            }
//        }
//
//        // Optional: Restore the array to its original state
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Math.abs(nums[i]);
//        }
//
//        return duplicateCount;
//    }
}
