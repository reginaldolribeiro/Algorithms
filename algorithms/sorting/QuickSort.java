package algorithms.sorting;

public class QuickSort {

    /**
     * quick sort = moves smaller elements to left of a pivot.
     *              recursively divide array in 2 partitions
     *
     * run-time complexity = Best case O(n log(n))
     *                       Average case O(n log(n))
     *                       Worst case O(n^2) if already sorted
     *
     * Space complexity = 0(log(n)) due to recursion
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Initial: ");

//        int[] integers = {8,2,4,7,1,3,9,6,5};
//        int[] integers = {2,8,4,7,1};
//        int[] integers = {5,8,2,3,7};
        int[] integers = {6,1,5,3,2,4};
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
        if(end <= start) return;
        int pivot = partition(integers, start, end);
        quickSort(integers, start, pivot-1);
        quickSort(integers, pivot + 1, end);
    }

    private static int partition(int[] integers, int start, int end) {
        int pivot = integers[end]; // Pivot is the last element
        int i = start -1; // Index of smaller element

        for(int j=start; j < integers.length; j++){
            if(integers[j] < pivot){
                i++;
                swap(integers, i, j);
            }
        }
        i++;
        swap(integers, i, end);

        return i;
    }

    private static void swap(int[] integers, int i, int j) {
        int temp = integers[i];
        integers[i] = integers[j];
        integers[j] = temp;
    }

}


//6,1,5,3,2,4
//
//1,6,5,3,2,4
//
//1,3,5,6,2,4
//
//1,3,2,6,5,4
//
//1,3,2,4,5,6
//
//pivot = 5
//
//1,3,2,4 -- 5 --- 6
//
//pivot = 4
//
//
//1,3,2,4


