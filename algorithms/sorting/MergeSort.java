package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
//        int[] integers = {8,2,4,7,1,3,9,6,5};
        int[] integers = {8,2,4,7,1};
//        int[] integers = {5,8,2,3,7};
//        int[] integers = {6,1,5,3,2,4};
//        int[] integers = {8,2,5,3,4,7,6,1};
//        int[] integers = {8,2,5,3};

//        Random random = new Random();
//        int[] integers = new int[10];
//        for (int k=0; k < integers.length; k++){
//            integers[k] = random.nextInt(10);
//        }

//        System.out.println("Initial: ");
//        printArray(integers);
//
//        mergeSort(integers);
//
//        System.out.println("\nFinal: ");
//        printArray(integers);

        List<Integer> arr = Arrays.asList(8,2,4,7,1);
        System.out.println("Initial: " + arr);

        mergeSort2(arr);

        System.out.println("\nFinal: " + arr);
    }

    /**
     * merge sort = recursively divide an array in 2, sort, re-combine
     * run-time complexity = 0(n Log n)
     * space complexity = 0(n)
     *
     * @param integers
     */
    private static void mergeSort(int[] integers) {
        int length = integers.length;
        if(length <= 1) return; // array vazio ou com somente 1 elemento
        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int j = 0; // for right array

        for(int i=0; i < length; i++){
            if(i < middle){
                leftArray[i] = integers[i];
            }else{
                rightArray[j] = integers[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, integers);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] integers) {
        if(leftArray.length == 0 || rightArray.length == 0) return;
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                integers[i] = leftArray[l];
                l++;
            } else {
                integers[i] = rightArray[r];
                r++;
            }
            i++;
        }
        while (l < leftSize){
            integers[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            integers[i] = rightArray[r];
            i++;
            r++;
        }
//        if(l == leftSize-1){
//            integers[i] = leftArray[l];
//            i++;
//            l++;
//        }
//
//        if(r == rightSize-1){
//            integers[i] = rightArray[r];
//            i++;
//            r++;
//        }
    }

    private static void printArray(int[] integers) {
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }

    // Approach 2

    private static void mergeSort2(List<Integer> arr) {
        int length = arr.size();
        if(length <= 1) return; // base case - empty array or array with one element
        int middle = length/2;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
//        int j = 0; // index for right array

        for(int i = 0; i < length; i++){
            if(i < middle){
                leftArray.add(arr.get(i));
            }else{
                rightArray.add(arr.get(i));
            }
        }
        mergeSort2(leftArray);
        mergeSort2(rightArray);
        merge2(arr, leftArray, rightArray);
    }

    // 8,2,4,7,1
    // 1,2 -- 7,8
    // 1,2,7,8
    private static void merge2(List<Integer> arr, List<Integer> leftArray, List<Integer> rightArray){
        if(leftArray.isEmpty() || rightArray.isEmpty())
            return;

        int l = 0;
        int r = 0;
        int i = 0;

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
        if(l < leftArray.size()){
            arr.set(i, leftArray.get(l));
            i++;
            l++;
        }
        if(r < leftArray.size()){
            arr.set(i, rightArray.get(r));
            i++;
            r++;
        }
    }

}
