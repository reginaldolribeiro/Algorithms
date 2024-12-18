package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSortPractice {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
//        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);

        System.out.println("Initial List: " + integers);

//        myBubbleSort1(integers);
        myBubbleSort2(integers);
//        myBubbleSort3(integers);

        System.out.println("Final list: " + integers);

    }

    /**
     * Approach 3
     * In this function we have 2 loops
     *
     * We start the first loop considering that “i” is equal to the size of the list and decrementing this variable
     * so as not to need to iterate in the last position as it is already sorted.
     * The inner (second) loop starts with "j" being less than "i" and comparing the current position to the next position if it is larger, change the position,
     * otherwise it is not necessary to change it.
     *
     * Complexity:
     *  O(n^2) for the worst scenario
     *  O(n) for the best scenario, which is when a list is already ordered.
     *
     * @param integers
     */
    private static void myBubbleSort3(List<Integer> integers){
        int n = integers.size()-1; // O(1)
        boolean swapped = false;
        int iterations = 0;

        for(int i=n; i > 0; i--){ // O(n)
            System.out.println("--");
            swapped = false;

            // The last "i" elements is already sorted
            for(int j=0; j < i; j++){ // O(n)
                if(integers.get(j) > integers.get(j+1)){ // O(1)
                    int temp = integers.get(j); // O(1)
                    integers.set(j, integers.get(j+1)); // O(1)
                    integers.set(j+1, temp); // O(1)
                    swapped = true;
                }
                System.out.println("Processed List " + j + " time(s): " + integers);
            }

            iterations++;

            // If there wasn't swap (or change) in this iteration, the list is already sorted
            if(!swapped) break;
        }

        System.out.println("\n iterations: " + iterations + "\n");
    }

    /**
     * Approach 2
     *
     * In this function we have 2 loops. The most internal loop (inner loop) iterates until
     * the last position that it doesn't sorted yet.
     *
     * Complexity:
     *  O(n^2) for the worst scenario
     *  O(n) for the best scenario, which is when a list is already ordered.
     *
     * Considered a bad complexity
     *
     * bubble sort = pairs of adjacent elements are compared, and the elements
     * 		            swapped if they are not in order.
     *
     * 				 Quadratic time O(n^2)
     * 				 small data set = okay-ish
     * 				 large data set = BAD (plz don't)
     *
     * @param integers
     */
    private static void myBubbleSort2(List<Integer> integers){
        int iterations = 0;
        int n = integers.size(); // O(1)
        boolean swapped = false;

        for(int i=0; i < n; i++){ // O(n)
            System.out.println("--");
            swapped = false;

            // The last "i" element is already sorted, is in right position
            for(int j=0; j < n - 1 - i; j++){ // O(n)
                if(integers.get(j) > integers.get(j+1)){ // O(1)
                    int temp = integers.get(j); // O(1)
                    integers.set(j, integers.get(j+1)); // O(1)
                    integers.set(j+1, temp); // O(1)
                    swapped = true;
                }
                System.out.println("Processed List " + j + " time(s): " + integers);
            }
            iterations++;
            if(!swapped) break;
        }

        System.out.println("\n iterations: " + iterations + "\n");

    }

    /**
     * Approach 1
     * In this function we just need one loop.
     * Complexity is O(n^2) for the Worst scenario and O(n) for the Best scenario,
     * which is when a list is already ordered.
     *
     * Calculating the complexity
     * O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) * O(n)
     * 6 O(1) + 2 (n) = O(n^2)
     *
     * @param integers
     */
    private static void myBubbleSort1(List<Integer> integers) {
        int n = integers.size()-1; // O(1)
        boolean swapped = false;
        int iterations = 0;

        do { // O(n)
            swapped = false;
            for(int i=0; i<n; i++){ // O(n)
                if(integers.get(i) > integers.get(i+1)){ // 2 O(1)
                    int temp = integers.get(i); // O(1)
                    integers.set(i, integers.get(i+1)); // O(1)
                    integers.set(i+1, temp); // O(1)
                    swapped = true;
                }
                System.out.println("Processed List " + i + " time(s): " + integers);
            }

            iterations++;
            n--;

        } while(swapped);

        System.out.println("\n iterations: " + iterations + "\n");
    }

}
