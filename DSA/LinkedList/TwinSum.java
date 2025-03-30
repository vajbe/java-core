//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
package DSA.LinkedList;

import java.util.Stack;

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

public class TwinSum {
    public int pairSum(ListNode head) {

        int midIndex = 0;
        ListNode midNode = head;
        ListNode fastNode = head;

        if (head.next.next == null) {
            return head.val + head.next.val;
        }

        while (fastNode.next.next != null) {
            midNode = midNode.next;
            fastNode = fastNode.next.next;
            midIndex++;
        }
        midNode = midNode.next;
        Stack<ListNode> s = new Stack<>();
        while (midNode != null) {
            s.push(midNode);
            midNode = midNode.next;
        }
        int i = 0;
        int maxSum = 0;
        ListNode curr = head;
        while (i < midIndex + 1) {
            ListNode currEl = s.pop();
            maxSum = Math.max(maxSum, currEl.val + curr.val);
            curr = curr.next;
            i++;

        }
        return maxSum;
    }
}