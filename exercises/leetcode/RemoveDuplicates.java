package exercises.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println("Result " + result);
    }

    /**
     * BEST efficiency
     *
     * Big O Notation
     *  Time: O(n)
     *  Space: O(1)
     *
     * Given a sorted array nums, remove duplicates in-place such that each element appears only once.
     * Return the new length of the modified array. The relative order of the elements must be maintained.
     *
     * Approach:
     *  Use a two-pointer technique.
     * 	• Start iterating from the second element (index = 1).
     * 	• Compare each element with its previous one (nums[i] != nums[i-1]).
     * 	• If they are different, update the element at the current index and increment the index.
     * 	• Return: The index represents the length of the array with unique elements.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums){
        if(nums.length == 0) return 0;

        int index = 1; // Start from the second element
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        // Print only the first unique numbers, which means 0 .. index
        for (int i = 0; i < index; i++) {
            System.out.println(nums[i]);
        }

        return index;
    }

    public static int removeDuplicates1(int[] nums) {
        if(nums.length == 0) return 0;

        int lastSeen = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(lastSeen != nums[i]){
                nums[index] = nums[i];
                lastSeen = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void removeDuplicatesElements1(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for(int value : nums){
            numbers.add(value);
        }
        for (int i = 1; i < numbers.size(); i++) { // O(n)
            if(numbers.get(i-1) == numbers.get(i)){
                System.out.println("Number " + numbers.get(i) + " is going to be removed!");
                numbers.remove(i); // O(n)
            }
        }
        System.out.println("Modified array " + numbers);
    }

//    public static int removeDuplicates(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            System.out.println("Number in previous index:" + (i-1) + " is " + nums[i-1] + " and in the Current index:" + i + " is " + nums[i]);
//            if(nums[i-1] == nums[i]){
//                nums[i] = 3;
//            }
//        }
//        return 0;
//    }
}
