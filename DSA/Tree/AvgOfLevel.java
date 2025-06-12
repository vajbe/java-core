package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevel {
    public List<Double> averageOfLevels(TreeNode root) {

        TreeNode head = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            long currentSum = 0;
            System.out.println("");
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.val;
                if (currentNode.left != null && currentNode.left.val != 0) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null && currentNode.right.val != 0) {
                    queue.offer(currentNode.right);
                }
            }
            double avg = (double) currentSum / size;
            result.add(avg);
            System.out.println(avg);
        }

        return result;
    }

    public static void main(String[] args) {
        AvgOfLevel a = new AvgOfLevel();
        TreeNode root = util.generateTreeFromArray(new int[] { 2147483647, 2147483647, 2147483647 });
        a.averageOfLevels(root);
    }
}
