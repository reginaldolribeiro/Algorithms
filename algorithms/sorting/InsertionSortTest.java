package algorithms.sorting;

public class InsertionSortTest {
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
     * 1. {64, 25, 12, 22, 11}
     * 1. {25, 64, 12, 22, 11}
     * 2. Check if the array is null, empty or length == 1
     * 3. Iterate through array
     * 4. Set another index like lastElement equal i-1
     * 5. While loop comparing the next element with last element checking if the last element is greater than the next element
     * 6. If the last element is greater than the next element, shift the last element to the right
     * @param integers
     */
    private static void insertionSortIntegers(int[] integers) {
        if(integers.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");
        if(integers.length == 1)
            return;

        for (int i = 1; i < integers.length; i++) {
            int j = i-1;
            int temp = integers[i];

            while(j >= 0 && integers[j] > temp){
                integers[j+1] = integers[j];
                j--;
            }
            integers[j+1] = temp;
        }
    }


}
