// https://leetcode.com/problems/partition-list/?envType=study-plan-v2&envId=top-interview-150

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

public class PartitionList {
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

    public ListNode partition(ListNode head, int x) {
        ListNode beforeNode = new ListNode(0);
        ListNode afterNode = new ListNode(0);
        ListNode before = beforeNode;
        ListNode after = afterNode;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        before.next = afterNode.next;
        after.next = null;
        return beforeNode.next;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(" -> " + head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 2, 5, 2 };
        ListNode head = createList(nums);

        PartitionList pl = new PartitionList();
        // pl.printList(head);
        ListNode l = pl.partition(head, 3);
        pl.printList(l);
    }
}
