//https://leetcode.com/problems/count-complete-tree-nodes/submissions/1649563253/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        CountNodes cn = new CountNodes();
        TreeNode root = util.generateTreeFromArray(new int[] { 1, 2, 3, 4, 5, 6 });
        System.out.println(cn.countNodes(root));
    }
}
