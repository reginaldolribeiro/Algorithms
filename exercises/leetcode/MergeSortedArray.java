package exercises.leetcode;

public class MergeSortedArray {

    /**
     * Questions
     * 1. Are these arrays only having numbers?
     *      Yes!
     * 2. What should I do if both are null or empty? Nothing?
     *      Throw an error or just do nothing.
     * 3. What should I do if one or another are null or empty?
     *      Merge one to another, even one of them is empty.
     * 4. What should I do if the number m or n it's different from the size of the array?
     *      If the value of m or n is less or equal than the size of the array is ok, but if 0 or greater
     *      than the size of the array you should throw an error.
     * 5. Is there any maximum size for these arrays? Performance?
     *       The maximum size is one thousand.
     * 6. Should I just merge these two arrays and return nothing?
     *      Yes! Merge them.
     * 7. Considering these two arrays are int[] I won't be able to expand the size of the array. ********
     *    Should I assume that nums1 is pre-sized to fit all elements from both nums1 and nums2?
     *      Yes!
     *
     * Options:
     *  1. If the arrays are implementations of List, we can use addAll(), which iterates through the second array
     *      and appends each element to the end of the first array. This doesn’t maintain order.
     *      Complexity: O(n) for time and O(1) for space (assuming no new list is created).
     *
     *  2. If the arrays are implementations of List, we can use addAll(), which iterates through the second array
     *      and appends each element to the end of the first array. This doesn’t maintain order.
     *      Complexity: O(n) for time and O(1) for space (assuming no new list is created).
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n, 3);

//        int[] nums1 = {4,5,6,0,0,0};
//        int[] nums2 = {1,2,3};
//        int m = 3, n = 3;
//        merge(nums1, m, nums2, n);

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        int m = 1, n = 0;
//        merge(nums1, m, nums2, n);

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        int m = 0, n = 1;
//        merge(nums1, m, nums2, n);

//        System.out.println("*** Merged array ***");
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i]);
//        }
    }


    // {4,5,6,0,0,0} -- {1,2,3}
    // {1,2,3,0,0,0} -- {2,5,6}
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
//            throw new IllegalArgumentException("Arrays must not be null or empty");
//        // If nums2 is empty, no merging is necessary
//        if(n == 0){
//            return;
//        }
//        // Se `m == 0`, apenas copie todos os elementos de `nums2` para `nums1`
//        if (m == 0) {
//            System.arraycopy(nums2, 0, nums1, 0, n);
//            return;
//        }
//        int nums1Index = m - 1;
//        int nums1TotalIndex = m + n - 1;
//        int nums2Index = n - 1;
//
//        while (nums2Index >= 0){
//            if(nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index]){
//                nums1[nums1TotalIndex] = nums1[nums1Index];
//                nums1Index--;
//            } else {
//                nums1[nums1TotalIndex] = nums2[nums2Index];
//                nums2Index--;
//            }
//            nums1TotalIndex--;
//        }
//
//        for (int i = 0; i < k; i++) {
//            System.out.println(nums1[]);
//        }
//    }


    /**
     * Merges two sorted arrays, nums1 and nums2, into a single sorted array in-place within nums1.
     * <p>
     * The nums1 array is assumed to have a size of at least m + n, where the first m elements represent
     * the initial sorted elements, and the remaining n elements are set to 0, acting as placeholders.
     * The nums2 array has exactly n sorted elements that should be merged into nums1, preserving the order.
     *
     * <p><b>Big O Notation:</b></p>
     * <ul>
     *   <li>Time Complexity: O(m + n) - This algorithm iterates over both nums1 and nums2 once,
     *       merging them in a single pass from the end to the beginning.</li>
     *   <li>Space Complexity: O(1) - This operation is performed in-place within nums1, using no additional memory.</li>
     * </ul>
     *
     * @param nums1 the first sorted array with a size of at least m + n, containing m valid elements followed by n placeholders (zeros).
     * @param m the number of initial sorted elements in nums1.
     * @param nums2 the second sorted array containing n sorted elements to be merged into nums1.
     * @param n the number of elements in nums2.
     * @throws IllegalArgumentException if either nums1 or nums2 is null or empty.
     */
    // {4,5,6,0,0,0} -- {1,2,3}
    // {1,2,3,0,0,0} -- {2,5,6}
    public static void merge(int[] nums1, int m, int[] nums2, int n, int k) {
        if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
            throw new IllegalArgumentException("Arrays must not be null or empty");

        // If nums2 is empty, no merging is necessary
        if(n == 0){
            return;
        }

        int lastMaximumValueIndex = m - 1; // Pointer for the last valid element in nums1
        int nums1Index = m + n - 1; // Position to fill in nums1 (from end to start)
        int nums2Index = n - 1; // Pointer for the last element in nums2

        // Merge from the end of both arrays to maintain sorted order
        while(nums2Index >= 0 && nums1Index > 0 && lastMaximumValueIndex >= 0){
            if (nums2[nums2Index] >= nums1[lastMaximumValueIndex]){
                nums1[nums1Index] = nums2[nums2Index];
                nums2Index--;
            } else {
                nums1[nums1Index] = nums1[lastMaximumValueIndex];
                lastMaximumValueIndex--;
            }
            nums1Index--;
        }

        // If there are remaining elements in nums2, copy them into nums1
        while(lastMaximumValueIndex < 0 && nums2Index >= 0){
            nums1[lastMaximumValueIndex + (nums2Index + 1)] = nums2[nums2Index];
            nums2Index--;
        }

        // Print K first elements
        for (int i = 0; i < k; i++) {
            System.out.println(nums1[i]);
        }
    }



    // {1,2,3,0,0,0} -- {2,5,6}
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
//            throw new IllegalArgumentException("Arrays must not be null or empty");
//        int i = m + (n-1);
//        int j = (n == 0) ? 0 : n-1;
//        while(j >= 0 && n > 0){
//            if(m == 0){
//                nums1[i] = nums2[j];
//                i--;
//                j--;
//            } else if(nums2[j] >= nums1[m-1]){
//                nums1[i] = nums2[j];
//                i--;
//                j--;
//            } else {
//                nums1[i] = nums1[i-1];
//                nums1[i-1] = nums2[j];
//                i--;
//                j--;
//            }
//        }
//    }


//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
//            throw new IllegalArgumentException("Arrays must not be null or empty");
//        int i = 0, j = 0;
//        while(j < nums2.length){
//            if(nums2[j] == nums1[i]){
//                i++;
//                j++;
//            } else if(nums1[i] == 0){
//                nums1[i] = nums2[j];
//                i++;
//                j++;
//            } else if(nums2[j] > nums1[i]){
//                i++;
//            }
//        }
//    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
//            throw new IllegalArgumentException("Arrays must not be null or empty");
//
//        int nums2Index = nums2.length;
//        for (int i = 0; i < nums1.length; i++) {
//            nums2[nums2Index] = nums1[i];
//        }
//    }

}
