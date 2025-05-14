//https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
package DSA.LinkedList;

public class ReversePositionedLL {
    ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return temp.next;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode list = util.createList(nums);
        ReversePositionedLL l = new ReversePositionedLL();
        l.reverseBetween(list, 2, 4);
        util.printList(list);
    }

}
