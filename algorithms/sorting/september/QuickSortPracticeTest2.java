package algorithms.sorting.september;

public class QuickSortPracticeTest2 {
    public static void main(String[] args) {
        System.out.println("Initial: ");

        int[] integers = {8,2,4,7,1,3,9,6,5};
//        int[] integers = {2,8,4,7,1};
//        int[] integers = {5,8,2,3,7};
//        int[] integers = {6,1,5,3,2,4};
//        int[] integers = {1,2,3,4};

        for (int i : integers) {
            System.out.println(i);
        }

        quickSort(integers, 0, integers.length-1);

        System.out.println("Final: ");
        for (int i : integers) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] integers, int start, int end) {
        if(end <= start) return; // base case. condicao de parada

        int pivot = partition(integers, start, end);
        quickSort(integers, start, pivot-1);
        quickSort(integers, pivot+1, end);
    }

    private static int partition(int[] integers, int start, int end) {
        int pivot = integers[end];
        int i = start-1;

        for (int j = start; j < end; j++) {
            if(integers[j] < pivot){
                i++;
                int temp = integers[i];
                integers[i] = integers[j];
                integers[j] = temp;
            }
        }
        i++;
        int temp = integers[i];
        integers[i] = integers[end];
        integers[end] = temp;

        return i;
    }
}
