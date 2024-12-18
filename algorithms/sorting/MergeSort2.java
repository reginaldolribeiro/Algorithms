package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort2 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(8,2,4,7,1);
//        List<Integer> arr = Arrays.asList(8,2,5,3,4,7,6,1);
        System.out.println("Initial: " + arr);

        mergeSort(arr);

        System.out.println("\nFinal: " + arr);
    }

    // 8,2,4,7,1
    private static void mergeSort(List<Integer> arr) {
        int length = arr.size();

        if(length <= 1) return; // base case - empty array or array with one element

        int middle = length/2;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i = 0; i < length; i++){
            if(i < middle){
                leftArray.add(arr.get(i));
            }else{
                rightArray.add(arr.get(i));
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arr, leftArray, rightArray);
    }

    // 8,2,4,7,1
    // 1,2 -- 7,8
    // 1,2,7,8
    private static void merge(List<Integer> arr, List<Integer> leftArray, List<Integer> rightArray){
        if(leftArray.isEmpty() || rightArray.isEmpty())
            return;

        int l = 0, r = 0, i = 0;

        while(l < leftArray.size() && r < rightArray.size()){
            if(leftArray.get(l) < rightArray.get(r)){
                arr.set(i, leftArray.get(l));
                l++;
            } else {
                arr.set(i, rightArray.get(r));
                r++;
            }
            i++;
        }
        while(l < leftArray.size()){
            arr.set(i, leftArray.get(l));
            i++;
            l++;
        }
        while(r < rightArray.size()){
            arr.set(i, rightArray.get(r));
            i++;
            r++;
        }
    }

}
