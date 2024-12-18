package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSortTest {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(8,2,4,7,1,3,9,6,5);
//        List<Integer> arr = Arrays.asList(8,2,4,7);
        System.out.println("Unordered Array: " + arr);

        quickSort(arr, 0, arr.size()-1);

        System.out.println("Ordered Array: " + arr);
    }

    private static void quickSort(List<Integer> arr, int start, int end){
        if(end <= start) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    // (8,2,4,7) - i=0; j=1;
    // (2,8,4,7) - i=1; j=2;
    // (2,4,8,7) - reaches our pivot (7); i=2; swap 7 and 8
    // (2,4,7,8)

    private static Integer partition(List<Integer> arr, int start, int end) {
        int pivot = arr.get(end);
        int j = start;
        int i = j-1;

        while (j < end){
            if(arr.get(j) <= pivot){
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
            j++;
        }

        i++;
        int temp = arr.get(i);
        arr.set(i, pivot);
        arr.set(end, temp);
        return i;
    }
}
