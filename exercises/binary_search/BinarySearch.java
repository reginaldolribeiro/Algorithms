package exercises.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int[] nums = new int[]{-1,0,3,5,9,12,13};
//        int target = 9;
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 2;
//        int[] nums = new int[]{1,2,3,4};
//        int target = 4;
//        int[] nums = new int[]{1,2};
//        int target = 1;
//          int[] nums = new int[]{1};
//          int target = 2;
        int[] nums = new int[]{1,2,3,4};
        int target = 1;

//        int[] nums = new int[1000000];
//        int target = 777777;
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = i;
//        }
//        int result = binarySearch(nums, target);
//        System.out.println("Result index: " + result);

//        int result2 = Arrays.binarySearch(nums, target);
//        System.out.println("result 2 index: " + result2);

        int result = binarySearchRecursively(nums, target);
        System.out.println("Result index: " + result);
    }

    private static int binarySearchRecursively(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        return binarySearchRecursivelyHelper(nums, target, start, end);
    }
    private static int binarySearchRecursivelyHelper(int[] nums, int target, int start, int end) {
        if(start > end)
            return -1;
        int middle = start + (end - start)/2;
        int value = nums[middle];

        if(target > value)
            start = middle + 1;
        else if(target < value)
            end = middle - 1;
        else
            return middle;

        return binarySearchRecursivelyHelper(nums, target, start, end);
    }

    private static int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int middle = start + (end - start)/2;
            int value = nums[middle];

            System.out.println("middle: " + value);

            if(target < value)
                end = middle-1;
            else if(target > value)
                start = middle+1;
            else
                return middle;
        }
        return -1;
    }
}
