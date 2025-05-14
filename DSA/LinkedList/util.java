package DSA.LinkedList;

public class util {
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

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print("  " + head.val);
            head = head.next;
        }
        System.out.println();
    }

}
