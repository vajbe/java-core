// https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
package DSA.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static ListNode createList(int[] list) {
        ListNode head = new ListNode(list[0]);
        ListNode ptr = head;
        for (int i = 1; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            ptr.next = node;
            ptr = node;
        }
        return head;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null || head.next == null) {
            return false;
        }

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 0, -4 };
        ListNode head = createList(nums);
        System.out.println("Has cycle: " + hasCycle(head));
    }
}
