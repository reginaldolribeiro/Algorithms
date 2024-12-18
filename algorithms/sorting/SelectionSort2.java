package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class SelectionSort2 {

    public static void main(String[] args) {
        int[] integers = {64, 25, 12, 22, 11};
        System.out.println("--- INTEGERS ----");

        for(int i: integers){
            System.out.println("Initial array: " + i + "\n");
        }

        selectionSortIntegers(integers);

        for(int i : integers){
            System.out.println("\nFINAL array: " + i);
        }
    }

    /**
     * Search through an array and keep track of the minimum value during each iteration. At the end of each iteration, we swap variables.
     * Quadratic time 0(n^2)
     * small data set = okay
     * large data set = BAD
     * @param integers
     */
    // 1 ... {64, 25, 12, 22, 11}
    // 2 ... {11, 25, 12, 22, 64}
    // 3 ... {11, 12, 25, 22, 64}
    // 4 ... {11, 12, 22, 25, 64}
    private static void selectionSortIntegers(int[] integers) {
        int n = integers.length;
        for(int i=0; i < n-1; i++){
            int minIndex = i;
            System.out.println("Index " + i + " , number " + integers[i]);

            for(int j=i+1; j < n; j++){
                if(integers[j] < integers[minIndex]){
                    minIndex = j;
                    System.out.println(" - Loop n " + j + ", Index min is " + minIndex + ", value " + integers[minIndex]);
                }
            }

            int temp = integers[minIndex];
            integers[minIndex] = integers[i];
            integers[i] = temp;

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
