package exercises.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode root1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        root1.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        node3.next = new ListNode(-4, node2);
        var result = hasCycle(root1);
        System.out.println("\nHas cycle? " + result);

        System.out.println("\n*** Second Example ***");
        ListNode root2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2, root2);
        root2.next = node2_2;
        var result2 = hasCycle(root2);
        System.out.println("Has cycle? " + result2);

        System.out.println("\n*** Third Example ***");
        ListNode root3 = new ListNode(1);
        var result3 = hasCycle(root3);
        System.out.println("Has cycle? " + result3);
    }

    private static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }




    private static boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null)
            return false;

        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            if(visited.contains(current))
                return true;
            else
                visited.add(current);

            current = current.next;
        }

        return false;
    }

}
