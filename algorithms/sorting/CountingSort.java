package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(2, 5, 3, 0, 2, 3);
        List<Integer> arr = Arrays.asList(2, 5, 3, 0, 2, 3, 0, 3);
//        List<Integer> arr = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33);
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(
//                63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33
//        ));

        List<Integer> result = countingSort(arr);
//        List<Integer> result = countingSort2(arr);

        System.out.println("FINAL Count array " + result);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        int maxElement = arr.stream().mapToInt(a -> a).max().orElse(-1);
        int arraySize = maxElement + 1;
        List<Integer> countArray = new ArrayList<>(arraySize);
        for(int k=0; k < arraySize; k++){
            countArray.add(0);
        }

        for(int j=0; j < arr.size(); j++){
            int index = arr.get(j);
            countArray.set(index, countArray.get(index)+1);
        }

        List<Integer> sortedArray = new ArrayList<>();
        for (int i = 0; i < countArray.size(); i++) {
            int count = countArray.get(i);
            while (count > 0) {
                sortedArray.add(i);
                count--;
            }
        }

        return sortedArray;
    }

//    public static List<Integer> countingSort(List<Integer> arr) {
//        int maxValue = Collections.max(arr);
//        List<Integer> countArray = new ArrayList<>(Collections.nCopies(maxValue + 1, 0));
//        // Count the occurrences of each number in the input array
//        for (int num : arr) {
//            countArray.set(num, countArray.get(num) + 1);
//        }
//        return countArray;
//    }

//    public static List<Integer> countingSort2(List<Integer> arr) {
//        int maxElement = arr.stream().mapToInt(a -> a).max().orElse(-1);
//        int arraySize = maxElement + 1;
//        List<Integer> countArray = new ArrayList<>(arraySize);
//        for(int i=0; i < arraySize; i++){
//            countArray.add(0);
//        }
//
//        for(int j=0; j < arr.size(); j++){
//            int index = arr.get(j);
//            countArray.set(index, countArray.get(index)+1);
//        }
//
//        return countArray;
//    }
//
    public static List<Integer> countingSort2(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return arr;
        }

        // Step 1: Find the maximum element in the array
        int maxElement = arr.stream().mapToInt(a -> a).max().orElse(-1);

        // Step 2: Create a count array to store count of occurrences
        int arraySize = maxElement + 1;
        List<Integer> countArray = new ArrayList<>(arraySize);
        for(int k=0; k < arraySize; k++){
            countArray.add(0);
        }


        // Step 3: Count occurrences of each integer
        for(int j=0; j < arr.size(); j++){
            int index = arr.get(j);
            countArray.set(index, countArray.get(index)+1);
        }

        // (2, 5, 3, 0, 2, 3)
        // (0, 0, 0, 0, 0, 0) - inicio
        // (0, 0, 1, 0, 0, 0) - j = 0
        // (0, 0, 1, 0, 0, 1) - j = 1
        // (0, 0, 1, 1, 0, 1) - j = 2
        // (1, 0, 1, 1, 0, 1) - j = 3
        // (1, 0, 2, 1, 0, 1) - j = 4
        // (1, 0, 2, 2, 0, 1) - j = 5


        // Step 4: Modify count array to accumulate counts
        for (int k = 1; k <= maxElement; k++) {
            countArray.set(k, countArray.get(k) + countArray.get(k - 1));
        }

        // (1, 0, 2, 2, 0, 1) - inicio
        // (1, 1, 2, 2, 0, 1) - k = 1
        // (1, 1, 3, 2, 0, 1) - k = 2
        // (1, 1, 3, 5, 0, 1) - k = 3
        // (1, 1, 3, 5, 5, 1) - k = 4
        // (1, 1, 3, 5, 5, 6) - k = 4

        // Step 5: Build the sorted array using the count array
        List<Integer> sortedArray = new ArrayList<>(arr.size());
        for (int i = arr.size() - 1; i >= 0; i--) {
            int num = arr.get(i);
            int index = countArray.get(num) - 1;
            sortedArray.add(index, num);
            countArray.set(num, countArray.get(num) - 1);
        }

        // (2, 5, 3, 0, 2, 3) - arr

        // (1, 1, 3, 5, 5, 6) - inicio
        // countArray (1, 1, 3, 2, 5, 6)    - i = 5, num = 3, index = 3
        // sortedArray (null,null,null,3)   - i = 5, num = 3, index = 3

        // countArray (1, 1, 1, 2, 5, 6)    - i = 4, num = 2, index = 2
        // sortedArray (null,null,2,3)      - i = 4, num = 3, index = 3

        // countArray (0, 1, 1, 2, 5, 6)    - i = 3, num = 0, index = 1
        // sortedArray (null,1,2,3)         - i = 3, num = 3, index = 3

        // countArray (0, 1, 1, 2, 5, 6)    - i = 2, num = 3, index = 4
        // sortedArray (null,1,2,3,3)       - i = 2, num = 3, index = 3

        // countArray (0, 1, 1, 2, 5, 5)    - i = 1, num = 5, index = 5
        // sortedArray (null,1,2,3,3,5)     - i = 1, num = 3, index = 3

        // countArray (0, 1, 1, 2, 5, 5)    - i = 0, num = 2, index = 0
        // sortedArray (2,1,2,3,3,5)        - i = 0, num = 3, index = 3

        return sortedArray;
    }

}
