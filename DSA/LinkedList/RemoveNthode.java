//https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
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

public class RemoveNthode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        if (n < 1) {
            return head;
        }
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int position = length - n;

        curr = head;

        while (position > 1) {
            curr = curr.next;
            position--;
        }

        if ((head == curr) && (position == 0)) {
            head = head.next;
            return head;
        }

        ListNode nextNode = curr.next;
        curr.next = nextNode.next;
        nextNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthode n = new RemoveNthode();
        ListNode head = new ListNode(0);
        n.removeNthFromEnd(head, 1);
    }
}
