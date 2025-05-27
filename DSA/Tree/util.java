package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class util {
    public static TreeNode generateTreeFromArray(int arr[]) {
        if (arr == null || arr.length == 0)
            return null;
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                queue.add(current.left);
            }
            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                queue.add(current.right);
            }
        }
        return head;
    }
}
