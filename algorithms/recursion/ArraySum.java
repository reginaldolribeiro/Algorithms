package algorithms.recursion;

public class ArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6};
        int result = sumRecursive(arr);
        System.out.println("Sum " + result);
    }

    /**
     * Wrapper method to calculate the sum of an array recursively.
     * Handles edge cases like an empty array.
     *
     * @param arr Input array of integers
     * @return Sum of all elements in the array
     */
    private static int sumRecursive(int[] arr){
        // Handle the edge case of an empty array
        if(arr == null || arr.length == 0)
            return 0;
        // Call the helper function with the full range of the array
        return sumRecursiveHelper(arr, 0, arr.length-1);
    }

    /**
     * Helper method to calculate the sum recursively.
     * Processes one element at a time, starting from the given index.
     *
     * @param arr   The input array containing integers to be summed.
     * @param start The starting index of the range (inclusive).
     * @param end   The ending index of the range (inclusive).
     * @return The sum of elements in the array from the start index to the end index.
     */
    private static int sumRecursiveHelper(int[] arr, int start, int end) {
        // Base condition: if start equals end, return the last element
        if(start == end)
            return arr[start];

        // Add the current element and recursively process the rest of the array
        return arr[start] + sumRecursiveHelper(arr, start+1, end);
    }

}
