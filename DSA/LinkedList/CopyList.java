//https://leetcode.com/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-interview-150s
package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyList {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Map<Node, Node> oldNew = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            oldNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            oldNew.get(curr).next = oldNew.get(curr.next);
            oldNew.get(curr).random = oldNew.get(curr.random);
            curr = curr.next;
        }
        return oldNew.get(head);
    }

    public static void main(String[] args) {

    }
}
