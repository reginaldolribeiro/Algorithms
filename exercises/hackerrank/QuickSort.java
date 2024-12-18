package exercises.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4, 5, 3, 7, 2);
        List<Integer> result = quickSort(integers);
        System.out.println("FINAL " + result);
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i=1; i < arr.size(); i++){
            if(arr.get(i) > pivot){
                right.add(arr.get(i));
            }else{
                left.add(arr.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.add(pivot);
        result.addAll(right);

        System.out.println(result);
        return result;
    }

}
