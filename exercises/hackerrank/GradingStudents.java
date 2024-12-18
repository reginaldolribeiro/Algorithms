package exercises.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(73,67,38,33);
        List<Integer> results = gradingStudents(grades);
        System.out.println("Result " + results); // Expected: 75, 67, 40, 33
    }


    /**
     * Rules:
     *  1. If grade < 38 don't rounding. Return the original grade. Still failed.
     *  2. If grade < 40 is failed. Rounding UP.
     *  3. If grade > 40 and
     *      is multiple of 5, it returns the original grade.
     *          if(grade modulus 5 == 0)
     *      is NOT multiple of 5, take the next multiple of 5 and subtract the original grade.
     *              if(grade modulus 5 != 0)
     *          If the result is less than 3, round grade up to the next multiple of 5
     *          If NOT, return the original grade
     *
     *  Questions?
     *      1. Grades empty? throw Exception
     *      2. Grade zero? failed? What is failed? return zero?
     *      3.
     *
     * Big O Notation
     *  - Time: O(n)
     *  - Space: O(n)
     *
     * Pros:
     *  - Avoids modifying the original list, so there are no side effects.
     * 	- Easier to understand as a transformation from input to output.
     * Cons:
     *  - Requires additional memory for the new list.
     *
     * @param grades
     * @return
     */
    public static List<Integer> gradingStudents(List<Integer> grades){
        if(grades.isEmpty()) throw new IllegalArgumentException();
        List<Integer> result = new ArrayList<>();

        for(Integer grade : grades){
            if(grade >= 38){
                if(grade % 5 != 0){
                    int nextMultipleOfFive = grade + (5 - grade % 5);
                    if(nextMultipleOfFive - grade < 3){
                        result.add(nextMultipleOfFive);
                        continue;
                    }
                }
            }
            result.add(grade);
        }

        return result;
    }

    /**
     * Time Complexity:
     *  O(n): The method iterates through the grades list once, where n is the number of elements in the list.
     *
     * Space Complexity:
     *  O(1): The method modifies the list in place and uses only a constant amount of extra space for variables.
     *
     * Side Effects:
     *  Modifying the original list can lead to unintended side effects if the list is used elsewhere in your code.
     *
     * @param grades
     * @return
     */
    public static List<Integer> gradingStudents1(List<Integer> grades){
        if(grades.isEmpty()) throw new IllegalArgumentException();

        for (int i = 0; i < grades.size(); i++) {
            Integer grade = grades.get(i);
            if(grade >= 38){
                if(grade % 5 != 0){
                    int nextMultipleOfFive = grade + (5 - grade % 5);
                    if(nextMultipleOfFive - grade < 3){
                        grades.set(i, nextMultipleOfFive);
                    }
                }
            }
        }
        return grades;
    }

    /**
     * Big O Notation
     *  - Time: O(n), The method processes each grade once.
     *  - Space: O(n), Uses a new list to collect the results.
     *
     * Pros:
     *  - Concise and Readable: Stream API provides a clean and expressive way to handle transformations.
     *  - Functional Style: Avoids explicit loops and mutable state.
     *
     * Cons:
     * - Potential Overhead: Streams may introduce some overhead compared to traditional loops, though this is often minimal.
     *
     *
     * @param grades
     * @return
     */
    public static List<Integer> gradingStudents3(List<Integer> grades) {
        if (grades.isEmpty()) throw new IllegalArgumentException();

        return grades.stream()
                .map(grade -> {
                    if (grade >= 38 && grade % 5 != 0) {
                        int nextMultipleOfFive = grade + (5 - grade % 5);
                        if (nextMultipleOfFive - grade < 3) {
                            return nextMultipleOfFive;
                        }
                    }
                    return grade;
                })
                .collect(Collectors.toList());
    }



    public static List<Integer> gradingStudents2(List<Integer> grades){
        if(grades.isEmpty()) throw new IllegalArgumentException();
        List<Integer> result = new ArrayList<>();

        for(Integer grade : grades){
            int newGrade = grade;
            if(grade < 38){
                System.out.println("Grade " + grade + " is Failed. No rounding");
//            } else if (grade < 40) {
//                System.out.println("Grade " + grade + " is Failed. Rounding UP");
            } else {
                if(grade % 5 == 0){
                    System.out.println("Grade " + grade + " it will be returned");
                } else {
                    int nextMultipleOfFive = grade + (5 - grade % 5);
                    if(nextMultipleOfFive - grade < 3){
                        System.out.println("Grade " + grade + " is rounding Up to " + nextMultipleOfFive);
                        newGrade = nextMultipleOfFive;
                    } else {
                        System.out.println("Grade " + grade + " NO rounding");
                    }
                }
            }
            result.add(newGrade);
        }

        return result;
    }

}
