package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 3, 5, 6, 2);
        insertionSort2(integers.size(), integers);
    }

    public static void insertionSort2(int n, List<Integer> integers) {
        for(int i=1; i < integers.size(); i++){
            int temp = integers.get(i);
            int j = i-1;


            while(j >= 0 && integers.get(j) > temp){
                integers.set(j+1, integers.get(j));
                integers.set(j, temp);
                j--;
            }
            integers.forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }
}
