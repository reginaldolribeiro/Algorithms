package exercises.hackerrank;

import java.util.*;

public class SalesByMatch {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,1,2,1,3,2);
        int pairs = sockMerchant(arr.size(), arr);
        System.out.println(pairs);
    }

    private static int sockMerchant(int size, List<Integer> arr) {
        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            int sock = arr.get(i);
            if (set.contains(sock)) {
                pairs++;
                set.remove(sock);
            } else {
                set.add(sock);
            }
        }
        return pairs;
    }

    private static int sockMerchant1(int size, List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            Integer numberIndex = map.get(arr.get(i));
            if(numberIndex != null){
                pairs++;
                map.remove(arr.get(i));
            } else {
                map.put(arr.get(i), i);
            }
        }
        return pairs;
    }
}
