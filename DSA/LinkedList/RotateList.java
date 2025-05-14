//https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
package DSA.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        k = k % length;
        if (k == 0)
            return head;
        temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print("  " + head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {};
        ListNode head = createList(nums);
        RotateList rotate = new RotateList();
        rotate.printList(head);
        ListNode newList = rotate.rotateRight(head, 0);
        rotate.printList(newList);
    }
}
