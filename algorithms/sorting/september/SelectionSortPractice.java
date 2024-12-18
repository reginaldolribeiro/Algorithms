package algorithms.sorting.september;

import java.util.Arrays;
import java.util.List;

public class SelectionSortPractice {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);
        System.out.println("\nInitial List: " + integers + "\n");
        mySelectionSort(integers);
        System.out.println("FINAL List: " + integers);
    }
    // (7, 5, 10, 6, 8)
    // (5, 7, 10, 6, 8)
    // (5, 6, 10, 7, 8)
    // (5, 6, 7, 10, 8)
    private static void mySelectionSort(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j) < list.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
}
