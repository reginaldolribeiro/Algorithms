package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSortPractice3 {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(7, 5, 10, 6, 8);
//        List<Integer> integers = Arrays.asList(12, 3, 15, 2, 5, 6, 9, 8);

        System.out.println("Initial List: " + integers);

        myBubbleSort(integers);

        System.out.println("Final list: " + integers);
    }

    public static void myBubbleSort(List<Integer> array){
        if(array == null || array.isEmpty())
            return;

        for (int i = 0; i < array.size(); i++) {
            int first = array.get(i);
            for (int j = i+1; j < array.size(); j++) {
                if(first > array.get(j)){
                    array.set(i, array.get(j));
                    array.set(j, first);
                }
            }
        }
    }
}
