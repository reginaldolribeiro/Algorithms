package algorithms.sorting.september;

public class MergeSortPracticeTest {
    public static void main(String[] args) {
        int[] integers = {8,2,4,7,1};
        for (int i : integers) {
            System.out.println(i);
        }

        mergeSort(integers);

        System.out.println("Final: ");
        for (int i : integers) {
            System.out.println(i);
        }
    }

    // {8,2,4,7,1}
    // Recursively divide array in 2, sort, re-combine
    // O(n log n)
    private static void mergeSort(int[] integers) {
        int length = integers.length;
        if(length <= 1) return; // base case

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int r = 0;
        for (int i = 0; i < length; i++) {
            if(i < middle){
                leftArray[i] = integers[i];
            }else{
                rightArray[r] = integers[i];
                r++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, integers);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] integers) {
        if(leftArray.length == 0 || rightArray.length == 0) return;
        int i = 0, l = 0, r = 0;
        while(l < leftArray.length && r < rightArray.length){
            if(leftArray[l] < rightArray[r]){
                integers[i] = leftArray[l];
                l++;
            }else{
                integers[i] = rightArray[r];
                r++;
            }
            i++;
        }
        while(l < leftArray.length){
            integers[i] = leftArray[l];
            l++;
            i++;
        }
        while(r < rightArray.length){
            integers[i] = rightArray[r];
            r++;
            i++;
        }
    }
}
