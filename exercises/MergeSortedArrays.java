package exercises;

public class MergeSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,4,0,0,0};
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;

        int[] nums1 = {4,5,6,0,0,0};
//        int[] nums1 = {2,5,6,0,0,0};
        // {2,5,6,0,0,6}
        // {2,5,6,0,5,6}
        // {2,5,6,3,5,6}
        // {2,5,2,3,5,6}
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int i : nums1){
            System.out.println(i);
        }
    }


    private static void merge(int[] nums1, int m, int[] nums2, int n){
        // ultima posicao valida do array nums1 eh m-1
        int firstIndex = m-1;
        int secondIndex = n-1;
        int lastIndex = nums1.length-1; // or int lastIndex = m+n-1;

        while(lastIndex >= 0 && firstIndex >= 0 && secondIndex >= 0){
            if(nums1[firstIndex] > nums2[secondIndex]){
                nums1[lastIndex] = nums1[firstIndex];
                firstIndex--;
            } else {
                nums1[lastIndex] = nums2[secondIndex];
                secondIndex--;
            }
            lastIndex--;
        }
        while(secondIndex >= 0){
            nums1[lastIndex] = nums2[secondIndex];
            secondIndex--;
            lastIndex--;
        }
    }

}
