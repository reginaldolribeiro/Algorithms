package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest2 {
    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(8,2,4,7,1,3,9,6,5);
        List<Integer> arr = Arrays.asList(8,2,4,7);
        System.out.println("Unordered Array: " + arr);

        quickSort(arr, 0, arr.size()-1);

        System.out.println("Ordered Array: " + arr);
    }

    private static void quickSort(List<Integer> arr, int start, int end) {
        if(end <= start) return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    // (8,2,4,7)
    private static int partition(List<Integer> arr, int start, int end) {
        int pivot = arr.get(end);
        int i = start - 1;

        for (int j = start; j < arr.size(); j++) {
            if(arr.get(j) < pivot){
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        i++;
        int temp = arr.get(i);
        arr.set(i, pivot);
        arr.set(end, temp);

        return i;
    }
}
