package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class OrderingString {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Reginaldo", "Elaine");
        System.out.println("Unsorted strings: " + strings);
        strings.sort(null);
        System.out.println("Sorted strings: " + strings);


        System.out.println(strings.get(0).compareTo(strings.get(1)));
        System.out.println(strings.get(1).compareTo(strings.get(0)));
    }
}
