package algorithms.sorting.september;

import java.util.Arrays;
import java.util.List;

public class InsertionSortPractice {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);
        System.out.println("\nInitial List: " + integers + "\n");
        myInsertionSort(integers);
        System.out.println("FINAL List: " + integers);
    }

    // (7, 5, 10, 6, 8);
    // (5, 7, 10, 6, 8);
    private static void myInsertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i-1;

            while(j >= 0 && list.get(j) > temp){
                list.set(j+1, list.get(j));
                j--;
            }

            list.set(j+1, temp);
        }
    }
}
