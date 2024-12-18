package algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci2 {

    public static void main(String[] args) {
        int number = 10;
        List<Integer> list = fibonacci(number);
        System.out.println(list);

        System.out.println();
        printFibonacci(number);
    }

    /**
     * Big O Notation
     *  Time complexity: O(n)
     *  Space complexity: O(1)
     *
     * @param n
     */
    private static void printFibonacci(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non negative integer.");
        if(n==0) return;
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                System.out.println(a + " ");
            } else if (i == 1) {
                System.out.println(b + " ");
            } else {
                int next = a+b;
                System.out.println(next + " "); // 0,1,1,2,3
                a = b;
                b = next;
            }
        }
        System.out.println();
    }

    /**
     * Big O Notation
     *  Time complexity: O(n)
     *  Space complexity: O(n)
     *
     * @param n
     */
    private static List<Integer> fibonacci(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non negative integer.");

        // If n be zero, return an empty list
        if(n==0) return new ArrayList<>();

        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if(i < 2){
                numbers.add(i);
            } else {
                numbers.add(numbers.get(i-2) + numbers.get(i-1));
            }
        }
        return numbers;
    }
}

//0,1,
