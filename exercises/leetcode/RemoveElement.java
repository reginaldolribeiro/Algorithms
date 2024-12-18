package exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int[] nums = new int[]{2,2,3,3,4,5,6};
        int result = removeElement(nums, 2);
        System.out.println("Result " + result);
    }

    public static int removeElement(int[] nums, int val){
        int newSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[newSize] = nums[i];
                newSize++;
            }
        }
        return newSize;
    }





    public static int removeElement11(int[] nums, int val){
        if(nums.length == 0) throw new IllegalArgumentException("Array must not be null");

        int count = 0;
        int right = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            int indexRemoved = 0;
            if(nums[i] == val){
                System.out.println("Faz alguma coisa");
                indexRemoved = i;
                while(nums[right] == val){
                    nums[right] = -1;
                    right--;
                    count++;
                }
                nums[i] = nums[right];
                nums[right] = -1;
                right--;
                count++;
            }else{
                System.out.println("Nao faz nada");
            }
        }

        return nums.length - count;
    }



//    public static int removeElement(int[] nums, int val){
////        Arrays.sort(nums);
//        // 2,2,3,3,4,5,6
//
//        int result = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == val){
//                nums[i] = -1;
//                result -= 1;
//            }
//        }
//
//        return result;
//    }



    /**
     * Get the number of other elements that are different from the number passed as parameter
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement3(int[] nums, int val){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                count++;
        }
        return count;
    }

}
