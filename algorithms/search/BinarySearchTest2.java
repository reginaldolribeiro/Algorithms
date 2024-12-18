package algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BinarySearchTest2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();

        int[] integers = {1,2,3,4,5,6};
        int target = 10;
        int index = binarySearch(integers, target);
        if(index == -1){
            System.out.println("Element " + target + " not found.");
        }else{
            System.out.println("Element " + target + " found at position " + index);
        }
    }

    private static int binarySearch(int[] integers, int target){
        if(integers == null || integers.length == 0)
            throw new IllegalArgumentException("Array must be not null.");

        int low = 0;
        int high = integers.length-1;

        while(low <= high){
            int middle = low + (high - low)/2; // 5-0 = 5/2 = 2.5 = 2 --> 0+2 = 2
            if(target < integers[middle])
                high = middle - 1;
            else if(target > integers[middle])
                low = middle + 1;
            else
                return middle;
        }

        return -1;
    }
}
