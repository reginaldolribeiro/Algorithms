package exercises.leetcode.linkedlist;

public class MiddleLinkedList {
        public static void main(String[] args) {
    //        ListNode root = new ListNode(1,
    //                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            ListNode root = new ListNode(1,
                    new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5
                    , new ListNode(6))))));
            var result = middleNode(root);
            System.out.println("Middle is: " + result.val);
        }

    private static ListNode middleNode(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
