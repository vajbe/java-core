//https://leetcode.com/problems/count-complete-tree-nodes/submissions/1649563253/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    int depth(TreeNode root) {
        TreeNode node = root;
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        CountNodes cn = new CountNodes();
        TreeNode root = util.generateTreeFromArray(new int[] { 1, 2, 3, 4, 5, 6 });
        System.out.println(cn.countNodes(root));
    }
}
