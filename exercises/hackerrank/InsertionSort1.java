package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Link https://www.hackerrank.com/challenges/insertionsort1/problem?isFullScreen=true
 */
public class InsertionSort1 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 3, 5, 6, 2);
        insertionSort1(integers.size(), integers);
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        for(int i=arr.size()-1; i >= 0; i--){
            int temp = arr.get(i);
            int j = i-1;

            while(j >= 0 && arr.get(j) > temp){
                arr.set(j+1, arr.get(j));
                j--;
                arr.forEach(a -> System.out.print(a + " "));
                System.out.println();
            }
            arr.set(j+1, temp);
        }
        arr.forEach(a -> System.out.print(a + " "));
    }
}
