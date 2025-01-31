package algorithms.recursion;

public class Countdown {
    public static void main(String[] args) {
        int number = 3;
//        countdown(number);
        countdownIterative(number);
    }

    /**
     * Prints a countdown from the given number to 1 using recursion.
     *
     * @param number The starting number of the countdown.
     *               Must be a positive integer to initiate the countdown.
     */
    private static void countdown(int number) {
        // Base condition: Stop recursion when the number reaches 0 or less
        if (number <= 0)
            return;

        // Print the current number
        System.out.println(number);

        // Recursive call: Decrement the number by 1 and continue the countdown
        countdown(number - 1);
    }

    private static void countdownIterative(int number) {
        for (int i = number; i > 0; i--) {
            System.out.println(i);
        }
    }
}
