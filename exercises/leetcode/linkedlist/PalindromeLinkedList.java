package exercises.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 234. Palindrome Linked List
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Initialize the linked list: 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head6 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));

//        ListNode reverse = reverseLinkedList(head3);
//        printLinkedList(reverse);

        System.out.println(isPalindrome(head1));
        System.out.println(isPalindrome(head2));
        System.out.println(isPalindrome(head3));
        System.out.println(isPalindrome(head4));
        System.out.println(isPalindrome(head5));
        System.out.println(isPalindrome(head6));
//        printLinkedList(head);
//        reversePrintLinkedList(head);
    }

    /**
     * Checks if a linked list is a palindrome using the two-pointers technique.
     *
     * Technique:
     * - Two-pointers (slow and fast) to find the middle of the list.
     * - Reverse the second half of the list.
     * - Compare the first half with the reversed second half.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Traverse the list to find the middle (O(n)) + Reverse the second half (O(n)) + Compare two halves (O(n)).
     * - Space Complexity: O(1) — In-place reversal of the second half, no extra space used.
     *
     * @param head The head of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     *
     * Example: 1 -> 2 -> 2 -> 1
     */
    private static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) {
            return true; // An empty list or a single node list is always a palindrome
        }

        // Step 1: Find the middle of the linked list using two pointers.
        // The slow pointer moves 1 step at a time, while the fast pointer moves 2 steps.
        // This is known as the "slow-fast pointer technique" and ensures that when the fast pointer
        // reaches the end of the list, the slow pointer will be in the middle.
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode middle = slow;
        ListNode secondHalfStart = reverse(middle);

        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalfStart = head;
        while(secondHalfStart != null){
            if(firstHalfStart.val != secondHalfStart.val)
                return false; // Mismatch found, not a palindrome
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true; // If no mismatches found, it's a palindrome
    }
    /**
     * Reverses a linked list starting from the given head node.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Traverse the list once to reverse it.
     * - Space Complexity: O(1) — In-place reversal.
     *
     * @param head The head of the linked list to reverse.
     * @return The new head of the reversed linked list.
     */
    private static ListNode reverse(ListNode head){
        if(head == null)
            return head; // If the list is empty, return nulls

        ListNode current = head;
        ListNode previous = null;

        // Traverse the list and reverse the links
        while (current != null) {
            ListNode nextNode = current.next; // Save the next node
            current.next = previous;          // Reverse the pointer
            previous = current;               // Move the 'previous' pointer forward
            current = nextNode;               // Move the 'current' pointer forward
        }

        return previous; // Return the new head of the reversed list
    }

    // Tests ...

    /**
     * Checks if a linked list is a palindrome using an array.
     *
     * Big O Notation:
     * - Time Complexity: O(n) — Traverse the list to copy values into an array (O(n))
     *   + Compare elements using two pointers (O(n)).
     * - Space Complexity: O(n) — Extra space for the array to store linked list values.
     *
     * @param head The head of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    private static boolean isPalindrome2(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        // Step 1: Copy linked list values into an array
        ListNode current = head;
        while (current != null) {
            arr.add(current.val);
            current = current.next;
        }

        // Step 2: Use two pointers to check for palindrome
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            if (!arr.get(start).equals(arr.get(end))) {
                return false; // Mismatch found, not a palindrome
            }
            start++;
            end--;
        }
        return true; // All pairs matched, it's a palindrome
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

//    public static void reversePrintLinkedList(ListNode head){
//        Stack<ListNode> stack = new Stack<>();
//        ListNode current = head;
//        while(current != null){
//            stack.add(current);
//            current = current.next;
//        }
//        while(!stack.isEmpty()){
//            ListNode node = stack.pop();
//            System.out.print(node.val + " -> ");
//        }
//    }
}
