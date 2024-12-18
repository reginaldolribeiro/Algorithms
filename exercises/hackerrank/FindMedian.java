package exercises.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedian {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 3, 1, 2, 4,6);
//        int median = findMedian(arr);
        double median = findMedian2(arr);
        System.out.println("Median of array " + median);

    }

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        System.out.println("Sorted array " + arr);

        int median = arr.size() / 2;
        return arr.get(median);
    }

    public static double findMedian2(List<Integer> arr) {
        Collections.sort(arr);
        System.out.println("Sorted array " + arr);

        int size = arr.size();
        if (size % 2 == 1) {
            // Odd number of elements
            return arr.get(size / 2);
        } else {
            // Even number of elements
            int mid1 = arr.get(size / 2 - 1);
            int mid2 = arr.get(size / 2);
            return (mid1 + mid2) / 2.0;
        }
    }
}
