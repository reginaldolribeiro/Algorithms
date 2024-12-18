package exercises.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BigSortingTest {
    public static void main(String[] args) {
//        List<String> unsortedStrings = Arrays.asList("Reginaldo", "Elaine");
//        List<String> unsortedStrings = Arrays.asList("1","200","150","30");
        List<String> unsortedStrings = Arrays.asList("8","1","2","100","12303479849857341718340192371","3084193741082937","3084193741082938","111","200");
        System.out.println("Unsorted strings: " + unsortedStrings);

        List<String> sortedStrings = bigSorting(unsortedStrings);
        System.out.println("Sorted strings: " + sortedStrings);
    }

    public static List<String> bigSorting(List<String> unsorted) {
        Collections.sort(unsorted, (a, b) -> {
            if(a.length() != b.length()){
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        return unsorted;
    }
}
