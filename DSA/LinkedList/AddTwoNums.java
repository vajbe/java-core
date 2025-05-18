package DSA.LinkedList;

//https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Stack;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int lenOne = 0;
        int lenTwo = 0;
        ListNode headOne = l1;
        ListNode headTwo = l2;

        if (headOne == null && headTwo == null) {
            return null;
        }

        if (headOne == null) {
            return l2;
        } else if (headTwo == null) {
            return l1;
        }

        while (headOne != null) {
            lenOne++;
            headOne = headOne.next;
        }

        while (headTwo != null) {
            lenTwo++;
            headTwo = headTwo.next;
        }

        if (lenOne < lenTwo) {
            headOne = l2;
            headTwo = l1;
        } else {
            headOne = l1;
            headTwo = l2;
        }

        int carry = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode resultHead = new ListNode(0);
        ListNode curr = resultHead;

        while (headOne != null && headTwo != null) {
            int res = headOne.val + headTwo.val + carry;
            int q = res % 10;
            carry = res / 10;
            headOne = headOne.next;
            headTwo = headTwo.next;
            ListNode temp = new ListNode(q);
            curr.next = temp;
            curr = curr.next;
            stack.push(temp);
        }

        while (headOne != null) {
            int res = headOne.val + carry;
            int q = res % 10;
            carry = res / 10;
            ListNode temp = new ListNode(q);
            stack.push(temp);
            curr.next = temp;
            curr = curr.next;
            headOne = headOne.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr = curr.next;
        }

        /*
         * while (!stack.isEmpty()) {
         * ListNode node = stack.pop();
         * curr.next = node;
         * curr = curr.next;
         * }
         */

        return resultHead.next;
    }

    public static void main(String[] args) {
        AddTwoNums n = new AddTwoNums();
        int[] n1 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] n2 = { 9, 9, 9, 9 };
        ListNode l1 = util.createList(n1);
        ListNode l2 = util.createList(n2);
        ListNode result = n.addTwoNumbers(l1, l2);
        util.printList(result);
    }
}
