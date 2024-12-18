package exercises.leetcode;

public class TwoSumSorted1 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
//        int target = 18;
//        int target = 23;

        int[] result = twoSum(numbers, target);

        System.out.println((result.length > 0) ? ("Result " + result[0] + "," + result[1]) : "Not found");
    }

    /**
     * The empty -> return empty array
     * The array with less than 2 elements -> return empty array
     * The target could be a negative value
     * Maximum array size: 10.000 elements
     * The target value maximum is 32-bit integer
     * There will be exactly one solution
     * If no pair sums to the target -> return empty array
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return new int[]{};

        int start = 0;
        int end = numbers.length-1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum > target){
                end--;
            } else if(sum < target){
                start++;
            } else {
                return new int[]{start+1,end+1};
            }
        }

        return new int[]{};
    }

}
