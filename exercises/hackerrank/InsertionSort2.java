package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Link https://www.hackerrank.com/challenges/insertionsort2/problem?isFullScreen=true
 */
public class InsertionSort2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 3, 5, 6, 2);
        insertionSort2(integers.size(), integers);
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for(int i=1; i < arr.size(); i++){
            int temp = arr.get(i);
            int j = i-1;

            while(j >= 0 && arr.get(j) > temp){
                arr.set(j+1, arr.get(j));
                arr.set(j, temp);
                j--;
            }
            arr.forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }

    // Codigo gerado pelo Hackerrank
    public static void insertionSortHackerrank(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        for(int n: A){
            System.out.print(n+" ");
        }
    }
}
