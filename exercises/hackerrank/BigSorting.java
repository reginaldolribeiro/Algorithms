package exercises.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BigSorting {
    public static void main(String[] args) {
//        List<String> unsortedStrings = Arrays.asList("Reginaldo", "Elaine");
        List<String> unsortedStrings = Arrays.asList("1","200","150","30");
//        List<String> unsortedStrings = Arrays.asList("8","1","2","100","12303479849857341718340192371","3084193741082937","3084193741082938","111","200");
        System.out.println("Unsorted strings: " + unsortedStrings);

        List<String> sortedStrings = bigSorting(unsortedStrings);
        System.out.println("Sorted strings: " + sortedStrings);
    }

    public static List<String> bigSorting(List<String> unsorted) {
        Collections.sort(unsorted, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        return unsorted;
    }

    private static void quicksort(List<String> arr, int start, int end){
        if(end <= start) return;
        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot-1);
        quicksort(arr, pivot+1, end);
    }

    private static int partition(List<String> arr, int start, int end){
        String pivot = arr.get(end);
        int i = start-1;

        for (int j = start; j < end; j++) { // O(n)
            if(compare(arr.get(j), pivot) < 0){
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

    private static int compare(String a, String b){
        if(a.length() != b.length()){
            return a.length() - b.length();
        } else {
            return a.compareTo(b);
        }
    }
}
