package exercises.hackerrank;

import java.util.Arrays;
import java.util.List;

public class SimpleArraySum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3);
        int total = simpleArraySum(arr);
        System.out.println("Total is " + total);
    }

    private static int simpleArraySum(List<Integer> arr){
        int sum = 0;
        for (Integer num : arr){
            sum += num;
        }
        return sum;
    }
}
