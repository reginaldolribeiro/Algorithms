package algorithms.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] integers = {64, 25, 12, 22, 11};
        System.out.println("--- INTEGERS ----");
        for(int i: integers){
            System.out.println("Initial array: " + i);
        }
        insertionSortIntegers(integers);
        for(int i : integers){
            System.out.println("FINAL array: " + i);
        }
    }

    /**
     * insertion sort = after comparing elements to the left
     *                  shift elements to the right to make room to insert a value
     *
     *              Quadratic time 0(n^2)
     *              small data set = decent
     *              large data set = BAD
     *
     *              Less steps than Bubble Sort
     *              Best case is O(n) compared to Selection Sort O(n^2)
     *
     * @param arr
     */
    // {64, 25, 12, 22, 11}
    // {25, 64, 12, 22, 11}
    // {12, 25, 64, 22, 11}
    private static void insertionSortIntegers(int[] arr) {
        for(int i=1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
