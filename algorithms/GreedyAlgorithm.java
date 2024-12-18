package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 5, 10, 20, 50, 100);
        int change = 85;
        List<Integer> result = selectMinimum(integers, change);
        System.out.println("Result " + result);
    }

    private static List<Integer> selectMinimum(List<Integer> arr, int change){
        int size = arr.size()-1;
        List<Integer> result = new ArrayList<>();

        for (int i = size; i >= 0; i--) {
            Integer value = arr.get(i);
            while(change >= value){
                result.add(value);
                change = change - value;
            }
        }

        return result;
    }
}
