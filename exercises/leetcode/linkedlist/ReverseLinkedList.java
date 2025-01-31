package exercises.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Demonstrates reversing a linked list and printing it recursively.
 * Includes examples of initializing and reversing different linked lists.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        // Example 1: Reverse and print a simple linked list (1 -> 2 -> 3 -> 4 -> 5)
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = reverse(list);
        System.out.println("Reversed List:");
        printRecursively(result);

        // Example 2: Initialize and reverse multiple linked lists
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head6 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));

        // Reverse and print the lists
        System.out.println("\nReversed Linked Lists:");
        printRecursively(reverse(head1));
        System.out.println();
        printRecursively(reverse(head2));
        System.out.println();
        printRecursively(reverse(head3));
        System.out.println();
        printRecursively(reverse(head4));
        System.out.println();
        printRecursively(reverse(head5));
        System.out.println();
        printRecursively(reverse(head6));
    }

    /**
     * Reverses a linked list using a recursive helper function.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each node is visited once.
     * - Space Complexity: O(n) — Recursive calls use stack space proportional to the list size.
     *
     * @param head The head of the linked list to reverse.
     * @return The new head of the reversed linked list.
     */
    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head; // Base case: Empty list or single node
        return reverseHelper(head, null);
    }
    /**
     * Recursive helper function to reverse a linked list.
     *
     * @param head     The current node in the linked list.
     * @param previous The previous node in the reversed list.
     * @return The new head of the reversed linked list.
     */
    private static ListNode reverseHelper(ListNode head, ListNode previous){
        if(head == null)
            return previous; // Base case: Return the new head when we reach the end of the list

        ListNode nextNode = head.next; // Save the next node
        head.next = previous;   // Reverse the point
        previous = head;        // New previous

        return reverseHelper(nextNode, previous); // Recursion with the next node
    }
    /**
     * Recursively prints the values of a linked list.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each node is visited once.
     * - Space Complexity: O(n) — Recursive calls use stack space proportional to the list size.
     *
     * @param head The head of the linked list to print.
     */
    private static void printRecursively(ListNode head){
        if (head == null) {
            return; // Base case: Stop when the end of the list is reached
        }
        System.out.print(head.val + " -> ");
        printRecursively(head.next); // Recur for the next node
    }


    /**
     * Reverses a linked list iteratively.
     *
     * Steps:
     * 1. Check if the list is null or empty (implicitly handled in the loop).
     * 2. Use two pointers:
     *    - 'previous' initialized to null (to store the previous node).
     *    - 'current' initialized to the head (to traverse the list).
     * 3. Traverse the list:
     *    - Temporarily store the next node (`current.next`) in `nextNode`.
     *    - Update `current.next` to point to the previous node, reversing the link.
     *    - Move 'previous' and 'current' one step forward.
     * 4. Repeat until the list is fully reversed (when 'current' becomes null).
     * 5. Return 'previous' as the new head of the reversed list.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Traverses the list once.
     * - Space Complexity: O(1) — Uses constant space for pointers.
     *
     * @param head The head of the linked list to reverse.
     * @return The new head of the reversed linked list.
     */
    private static ListNode reverseIteratively(ListNode head){
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Temporarily store the next node
            current.next = previous;         // Reverse the link
            previous = current;              // Move 'previous' forward
            current = nextNode;              // Move 'current' forward
        }
        return previous; // 'previous' is the new head of the reversed list
    }
    /**
     * Prints the values of a linked list iteratively.
     *
     * Steps:
     * 1. Traverse the list starting from the head.
     * 2. Print each node's value followed by "->".
     * 3. Stop when the end of the list (null) is reached.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Traverses the list once.
     * - Space Complexity: O(1) — Uses no additional space.
     *
     * @param head The head of the linked list to print.
     */
    public static void printIteratively(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Prints the values of a linked list iteratively using a stack.
     *
     * Note:
     * - This method is for **testing purposes only**.
     * - It demonstrates the use of a stack for traversal but is not a modern or efficient approach
     *   compared to direct iteration (e.g., `printIteratively`).
     * - Using `Stack` is also considered outdated; modern alternatives like `Deque` are preferred.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Each node is processed once.
     * - Space Complexity: O(n) — Uses stack space proportional to the size of the list.
     *
     * @param head The head of the linked list to print.
     */
    private static void printIterativelyStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>(); // Legacy stack for demonstration
        stack.add(head); // Push the head node onto the stack
        while (!stack.isEmpty()) {
            var next = stack.pop();         // Pop the top node
            System.out.print(next.val + " -> ");
            if (next.next != null) {
                stack.add(next.next);       // Push the next node onto the stack
            }
        }
    }
    /**
     * Prints the values of a linked list iteratively using a modern Deque.
     *
     * Note:
     * - This method uses a **Deque** (Double-Ended Queue) instead of the legacy `Stack` class.
     * - `Deque` is preferred over `Stack` because it is part of the modern `java.util` package
     *   and supports both LIFO (stack) and FIFO (queue) operations efficiently.
     * - `Stack` is considered outdated as it is a subclass of `Vector`, which is synchronized and
     *   generally less efficient.
     *
     * @param head The head of the linked list to print.
     */
    private static void printIterativelyDeque(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        if (head != null) stack.push(head); // Push head to stack if not null
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            System.out.print(node.val + " -> ");
            if (node.next != null) stack.push(node.next); // Push next node
        }
    }

}
