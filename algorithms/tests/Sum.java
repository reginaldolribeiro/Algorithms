package algorithms.tests;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){ // O(1)
            System.out.println("Enter number1: ");
            int num1 = scanner.nextInt(); // O(n)

            System.out.println("Enter number2: ");
            int num2 = scanner.nextInt(); // O(n)

            System.out.println("Enter number3: ");
            int num3 = scanner.nextInt(); // O(n)

            int sum = num1+num2+num3; // O(1)

            System.out.println("The sum of 3 numbers is: " + sum);
        } catch (InputMismatchException e){ // O(1)
            System.out.println("Invalid input. Please enter integers only.");
        }
//        scanner.close();  // 10. Closing the scanner
    }

}
