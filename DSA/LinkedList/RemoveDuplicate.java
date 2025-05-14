// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

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

public class RemoveDuplicate {
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

    void printList(ListNode head) {
        while (head != null) {
            System.out.print("  " + head.val);
            head = head.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Boolean> duplicateMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            int val = temp.val;
            if (duplicateMap.containsKey(val)) {
                duplicateMap.put(val, true);
            } else {
                duplicateMap.put(val, false);
            }
            temp = temp.next;
        }

        temp = head;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (temp != null) {
            if (!duplicateMap.get(temp.val)) {
                curr.next = temp;
                curr = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;

        return newHead.next;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 3, 4, 4, 5 };
        // int[] nums = { 1, 1, 1, 2, 3 };
        int[] nums = { 1, 2, 2 };
        ListNode head = createList(nums);
        RemoveDuplicate dups = new RemoveDuplicate();
        ListNode newHead = dups.deleteDuplicates(head);
        dups.printList(newHead);
    }
}
