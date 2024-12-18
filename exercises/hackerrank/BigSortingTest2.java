package exercises.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class BigSortingTest2 {
    public static void main(String[] args) {
//        List<String> unsortedStrings = Arrays.asList("Reginaldo", "Elaine");
//        List<String> unsortedStrings = Arrays.asList("1","200","150","30");
        List<String> unsortedStrings = Arrays.asList("8","1","2","100","12303479849857341718340192371","3084193741082937","3084193741082938","111","200");

        System.out.println("Unsorted strings: " + unsortedStrings);

        List<String> sortedStrings = bigSorting(unsortedStrings);

        System.out.println("Sorted strings: " + sortedStrings);
    }

    public static List<String> bigSorting(List<String> unsorted) {
        quicksort(unsorted, 0, unsorted.size()-1);
        return unsorted;
    }

    private static void quicksort(List<String> arr, int start, int end){
        if(end <= start) return;
        int pivot = partition(arr, start, end);
        quicksort(arr, 0, pivot-1);
        quicksort(arr, pivot+1, end);
    }

    private static int partition(List<String> arr, int start, int end){
        String pivot = arr.get(end);
        BigInteger pivotAsInt = new BigInteger(pivot);
        int i = start-1;

        for (int j = start; j < arr.size(); j++) { // O(n)
            BigInteger valueAsInt = new BigInteger(arr.get(j));
            if(valueAsInt.compareTo(pivotAsInt) < 0){
                i++;
                String temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        i++;
        String temp = arr.get(i);
        arr.set(i, pivot);
        arr.set(end, temp);

        return i;
    }
}
