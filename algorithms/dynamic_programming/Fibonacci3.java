package algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci3 {
    public static void main(String[] args) {
        int n = 5;
        List<Integer> integers = printFibonacci(n);
        System.out.println("Array: " + integers);

//        int result = fibonacci(n);
//        System.out.println("/n Fibonacci " + n + " is: " + result);
    }

    // IF N = 0 dont print
    // IF N = negative, throw exception
    // Fibonacci is the sum of two previous numbers
    // Print N first numbers of Fibonacci sequence
    private static List<Integer> printFibonacci(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a1 positive integer");

        List<Integer> result = new ArrayList<>();

        if(n == 0) return result;

        int previous = 0, current = 1;
        for (int i = 0; i < n; i++) {
            if(i<=1){
                System.out.println(i);
                result.add(i);
            } else {
                int temp = previous + current;
                previous = current;
                current = temp;
                System.out.println(temp);
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * Fibonacci comecando no 1
     *
     * @param n
     * @return
     */
    private static List<Integer> printFibonacciStart1(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a1 positive integer");

        List<Integer> result = new ArrayList<>();

        if(n == 0) return result;

        int previous = 0, current = 1;
        for (int i = 1; i <= n; i++) {
            if(i<=1){
                System.out.println(i);
                result.add(i);
            } else {
                int temp = previous + current;
                previous = current;
                current = temp;
                System.out.println(temp);
                result.add(temp);
            }
        }
        return result;
    }




    // 0,1,1,2,3,5,8,13,21,34....
    /**
     * Criar duas variaveis, sendo que uma delas armazena o valor anterior e a outra a soma
     * variavel a = 0
     * variavel b = 1
     *
     * a = b
     * b = a+b
     */
    private static int fibonacci(int n){
        if(n < 0) throw new IllegalArgumentException("n must be a non-negative integer.");
        if(n <= 1){
            System.out.println("F(" + n + ") is: " + n);
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
            System.out.println("F(" + i + ") is: " + temp);
        }
        return b;
    }

    private static int fibonacciRecursive(int n){
        if(n <= 1) return n;
        return fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
    }


}
