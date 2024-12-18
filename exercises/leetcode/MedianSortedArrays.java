package exercises.leetcode;

public class MedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = 0;
        int[] arr = new int[nums1.length+nums2.length];
        for (int i = 0; i < arr.length; i++) {
            if(i <= nums1.length-1){
                arr[index] = nums1[i];
            }else{
                arr[index] = nums2[i];
            }
            index++;
        }
        return 0.0;
    }
}
