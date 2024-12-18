package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort2 {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(64, 25, 12, 22, 11);
        List<Integer> integers = Arrays.asList(8,2,4,7,1,3,9,6,5);
        System.out.println("--- INTEGERS ----");
        System.out.println("Initial array: " + integers + "\n");

        quickSortIntegers(integers);

        System.out.println("\nFINAL array: " + integers);
    }

    private static void quickSortIntegers(List<Integer> integers) {
        for(int i=-1; i < integers.size(); i++){
            int pivot = integers.get(integers.size()-1);

            for(int j=i+1; j < integers.size()-1; j++){
                if(integers.get(j) < pivot){
                    i++;
                    int temp = integers.get(j);
                    integers.set(j, integers.get(i));
                    integers.set(i, temp);
                }
                if(j == integers.size()-1){
                    i++;
                    int temp = integers.get(j);
                    integers.set(j, integers.get(i));
                    integers.set(i, temp);
                }
            }
        }
    }
}
