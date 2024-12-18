package exercises.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3,2,4,4,4,1,3);
        int count = birthdayCakeCandles(integers);
        System.out.println("Count " + count);
    }

    /**
     * Find the maximum integer in an array.
     * Count how many times this integer appears in the array
     * Return this count
     *
     * Big O Notation
     *  Time complexity: O(n) - The function processes each element of the input array once.
     *  Space complexity: O(1) - The function uses a fixed amount of extra space regardless of the input size.
     *
     * @param candles
     * @return
     */
    private static int birthdayCakeCandles(List<Integer> candles) {
        int maxNumber = 0;
        int count = 0;

        for (int i = 0; i < candles.size(); i++) {
            Integer currentValue = candles.get(i);
            if(currentValue > maxNumber){
                maxNumber = currentValue;
                count = 1;
            } else if (currentValue == maxNumber) {
                count++;
            }
        }

        return count;
    }

    private static int birthdayCakeCandles1(List<Integer> candles) {
        Integer max = candles
                .stream().max(Comparator.comparingInt(value -> value))
                .orElse(-1);
        return (int) candles.stream().filter(n -> n.intValue() == max).count();
    }
}
