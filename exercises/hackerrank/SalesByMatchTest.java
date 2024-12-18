package exercises.hackerrank;

import java.util.*;

public class SalesByMatchTest {

    /**
     * Questions
     * 1. Is the array only having numbers?
     *      Yes!
     * 2. What should I do if the array is null or empty? Should I return 0 (zero)?
     *      Yes! Return 0!
     * 3. What should I do if there are numbers without a pair? Should I just ignore them?
     *      Ignore them!
     * 4. Is there a maximum size for the array or any specific constraints I should be aware of regarding performance?
     *
     * 5. Should the result just be a number of pairs found?
     *      Yes!
     *
     */

    public static void main(String[] args) {
        int n = 7;
//        List<Integer> arr = Arrays.asList(1,2,1,2,1,2,2);
        List<Integer> arr = Arrays.asList(1,2,1,2,1,3,2);
//        List<Integer> arr = null;
//        List<Integer> arr = new ArrayList<>();
        int pairs = sockMerchant(n, arr);
        System.out.println("Pairs: " + pairs);
    }

    // 1,2,1,2,1,3,2
    public static int sockMerchant(int n, List<Integer> arr) {
        if(arr == null || arr.isEmpty())
            return 0;

        int pairs = 0;
        Set<Integer> other = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) { // O(n)
            int value = arr.get(i);
            // Set: 1,3,2 Pair: 2
            if(other.contains(value)){ // O(1)
                pairs++;
                other.remove(value); // O(1)
            } else {
                other.add(value); // O(1)
            }
        }

        return pairs;
    }

}
