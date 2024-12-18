package algorithms.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,6,7,8,9};
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int target = 777777;

//        int index = Arrays.binarySearch(array, 3);
        int index = binarySearch(array, target);

        if(index != -1){
            System.out.println("Element found at index " + index);
        }else{
            System.out.println("Element not found!");
        }
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length-1;

        while(low <= high){
            int middle = low + (high - low) / 2;
            int value = array[middle];

            System.out.println("middle " + middle);

            if(target < value)
                high = middle - 1;
            else if (target > value)
                low = middle + 1;
            else
                return middle; // target found

        }

        return -1; // target not found
    }
}
