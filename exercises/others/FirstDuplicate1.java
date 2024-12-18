package exercises.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstDuplicate1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 3, 5, 3, 2);
        // in this case the duplicate number to return is 3,because the second time that its appear it has a smaller index
        // if find the duplicate number, return it
        // if don't find the duplicate number, return -1
//        for(int i=0; i < numbers.size(); i++){
//            System.out.println("Number "+numbers.get(i));
//        }
        int duplicatedNumber = firstDuplicate(numbers);
        System.out.println("First duplicated is: " + duplicatedNumber);
    }

    /**
     * Clarification questions
     *
     * 1. Does the array contain only integers, or can it include other data types as well?
     * 2. How should the method handle edge cases such as a null array or an empty array? Should it throw an error,
     *      or return a specific value like 0 or -1?
     * 3. Is there a defined maximum size for the input array?
     * 4. Is the return just an index of the second duplicate index number?
     * 5. What is the range of integer values that the array can contain? Are negative numbers or zero allowed?
     * 6. What should the method return if no duplicates are found in the array?
     *
     *  Big O Notation
     *      Time: O(n)
     *      Space: O(n)
     *
     * @param numbers
     * @return
     */
    private static int firstDuplicate(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty())
            return -1;

        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(duplicates.contains(numbers.get(i))){
                return i;
            } else {
                duplicates.add(numbers.get(i));
            }
        }

        return -1;
    }

}
