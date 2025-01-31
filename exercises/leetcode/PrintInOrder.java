package exercises.leetcode;

import exercises.leetcode.concurrency.ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * A class demonstrating thread coordination to ensure methods are executed in a specific order.
 *
 * Problem Description:
 * Implement a class `Foo` that ensures three methods (`first`, `second`, `third`) are executed
 * in order, even if called by multiple threads in an arbitrary sequence.
 *
 * Example:
 * If three threads call the methods in the order `second`, `third`, `first`, the output should be:
 * "first"
 * "second"
 * "third"
 *
 * Solution:
 * - Use `CountDownLatch` to enforce the execution order by waiting for one thread to complete
 *   before proceeding to the next method.
 *
 * Big O Notation:
 * - Time Complexity: O(1) — Each method runs in constant time.
 * - Space Complexity: O(1) — `CountDownLatch` uses minimal space.
 */
public class PrintInOrder {

    public static void main(String[] args) {
        // Example test: Simulate thread calls to `Foo` methods
        int[] nums = new int[]{1, 2, 3}; // Representing threads
        List<ThreadTest> threads = new ArrayList<>();

        // Create thread-like tasks
        for (int i = 0; i < nums.length; i++) {
            threads.add(new ThreadTest(i));
        }

        // Create an instance of Foo
        Foo foo = new Foo();

        // Execute methods in threads
        try {
            foo.first(threads.get(0));
            foo.second(threads.get(1));
            foo.third(threads.get(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * A class that ensures methods are executed in order using `CountDownLatch`.
 *
 * Solution Explanation:
 * - `CountDownLatch` is used to block the execution of a method until the previous method completes.
 * - `secondLatch` ensures that `second` runs only after `first` is completed.
 * - `thirdLatch` ensures that `third` runs only after `second` is completed.
 */
class Foo {
    private final CountDownLatch secondLatch = new CountDownLatch(1); // Controls execution of `second`
    private final CountDownLatch thirdLatch = new CountDownLatch(1);  // Controls execution of `third`

    public Foo() { }

    /**
     * Executes the `first` method and signals that `second` can proceed.
     *
     * @param printFirst A `Runnable` that outputs "first".
     * @throws InterruptedException If the thread is interrupted while executing.
     */
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run(); // Outputs "first"
        secondLatch.countDown(); // Signal that `first` is complete
    }

    /**
     * Executes the `second` method after ensuring `first` is completed.
     *
     * @param printSecond A `Runnable` that outputs "second".
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void second(Runnable printSecond) throws InterruptedException {
        secondLatch.await(); // Wait for `first` to complete
        printSecond.run(); // Outputs "second"
        thirdLatch.countDown(); // Signal that `second` is complete
    }

    /**
     * Executes the `third` method after ensuring `second` is completed.
     *
     * @param printThird A `Runnable` that outputs "third".
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public void third(Runnable printThird) throws InterruptedException {
        thirdLatch.await(); // Wait for `second` to complete
        printThird.run(); // Outputs "third"
    }
}