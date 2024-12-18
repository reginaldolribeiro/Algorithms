package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class InsertionSort2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(64, 25, 12, 22, 11);
        System.out.println("--- INTEGERS ----");
        System.out.println("Initial array: " + integers + "\n");

        insertionSortIntegers(integers);

        System.out.println("\nFINAL array: " + integers);
    }

    private static void insertionSortIntegers(List<Integer> integers) {
        for(int i=1; i < integers.size(); i++){
            int temp = integers.get(i);
            int j = i-1;

            while(j >= 0 && integers.get(j) > temp){
                integers.set(j+1, integers.get(j));
                j--;
            }

            integers.set(j+1,temp);
        }
    }


}
