package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSortPractice1 {

    private static List<Integer> bubbleSort(List<Integer> numbers){
        int n = numbers.size() - 1;
        boolean swipped;
        int iterations = 0;

        do {
            swipped = false;
            for(int i = 0; i < n; i++){
                if (numbers.get(i) > numbers.get(i+1)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i+1));
                    numbers.set(i+1, temp);
                    swipped = true;
                }
                System.out.println("Processed List " + i + " time(s): " + numbers);
            }
            iterations++;
            n--; // After each loop, the biggest element is inputed in the right position
        } while (swipped);

//        while (swipped){
//            swipped = false;
//            for(int i = 0; i < n; i++){
//                if (numbers.get(i) > numbers.get(i+1)) {
//                    int temp = numbers.get(i);
//                    numbers.set(i, numbers.get(i+1));
//                    numbers.set(i+1, temp);
//                    swipped = true;
//                }
//                System.out.println("Processed List " + i + " time(s): " + numbers);
//                iterations++;
//            }
//            n--;
//        }

        System.out.println("\n iterations: " + iterations);
        return numbers;
    }

    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);
        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);

        System.out.println("Initial list: " + integers);

        bubbleSort(integers);

        System.out.println("----\n");
        System.out.println("Final list: " + integers);
    }

}
