package exercises;

import java.util.*;

public class RemoveDuplicatesUnsortedArray {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3,1,1,4,3,6,5,5,5,9,3));
//        numbers.add(20);
        var result = removeDuplicates(numbers);
        System.out.println(result);
    }

    /**
     * Removing duplicates preserving order
     *
     * @param numbers
     * @return
     */
    public static List<Integer> removeDuplicates(List<Integer> numbers){
        if(numbers == null || numbers.isEmpty())
            return new ArrayList<>();

        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);

        return new ArrayList<>(uniqueNumbers);
    }

    /**
     * Removing duplicates without preserving order
     *
     * @param numbers
     * @return
     */
    public static List<Integer> removeDuplicates1(List<Integer> numbers){
        if(numbers == null || numbers.isEmpty())
            return new ArrayList<>();

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return new ArrayList<>(uniqueNumbers);
    }
}
