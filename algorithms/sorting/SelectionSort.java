package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(64, 25, 12, 22, 11);
        System.out.println("--- INTEGERS ----");
        System.out.println("Initial array: " + integers + "\n");

        selectionSortIntegers(integers);

        System.out.println("\nFINAL array: " + integers);

//        System.out.println("\n--- STRINGS ----");
//        List<String> strings = Arrays.asList("banana", "apple", "orange", "pear", "grape");
//
//        System.out.println("Initial array: " + strings + "\n");
//
//        selectionSortStrings(strings);
//
//        System.out.println("\nFINAL array: " + strings);
    }

    /**
     * Search through an array and keep track of the minimum value during each iteration. At the end of each iteration, we swap variables.
     * Quadratic time 0(n^2)
     * small data set = okay
     * large data set = BAD
     * @param integers
     */
    private static void selectionSortIntegers(List<Integer> integers) {
        int n = integers.size();
        for(int i=0; i < n-1; i++){
            int minIndex = i;
            System.out.println("Index " + i + " , number " + integers.get(i));

            for(int j=i+1; j < n; j++){
                if(integers.get(j) < integers.get(minIndex)){
                    minIndex = j;
                    System.out.println(" - Loop n " + j + ", Index min is " + minIndex + ", value " + integers.get(minIndex));
                }
            }

            int temp = integers.get(minIndex);
            integers.set(minIndex, integers.get(i));
            integers.set(i, temp);

//            System.out.println("\n");
        }
    }

    private static void selectionSortStrings(List<String> strings) {
        int n = strings.size();
        for(int i=0; i < n-1; i++){
            int minIndex = i;
            System.out.println("Index " + i + " , number " + strings.get(i));

            for(int j=i+1; j < n; j++){
                if(strings.get(j).compareTo(strings.get(minIndex)) < 0)  {
                    minIndex = j;
                    System.out.println(" - Loop n " + j + ", Index min is " + minIndex + ", value " + strings.get(minIndex));
                }
            }

            String temp = strings.get(minIndex);
            strings.set(minIndex, strings.get(i));
            strings.set(i, temp);

//            System.out.println("\n");
        }
    }

}
