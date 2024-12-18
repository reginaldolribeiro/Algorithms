package algorithms.sorting.september;

public class InsertSort2 {
    public static void main(String[] args) {
        int[] integers = {12, 3, 15, 2, 5, 6, 9, 8};
//        int[] integers = {6,1,7,4,2,9,8,5,3};
        System.out.println("*** Unsorted List ***");
        for(Integer i : integers){
            System.out.print(" " + i);
        }
        myInsertionSort(integers);
        System.out.println("\n*** Sorted List ***");
        for(Integer i : integers){
            System.out.print(" " + i);
        }
    }

    public static void myInsertionSort(int[] integers){
        if(integers == null || integers.length <= 1) return;
        for (int i = 1; i < integers.length; i++) {
            int current = integers[i];
            int j = i - 1;
            while(j >= 0 && integers[j] > current){
                integers[j+1] = integers[j];
                j--;
            }
            integers[j+1] = current;
        }
    }
}
