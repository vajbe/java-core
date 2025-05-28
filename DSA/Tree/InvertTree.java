//https://leetcode.com/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class InvertTree {
    void swapNodes(TreeNode root) {
        if (root != null) {
            TreeNode backup = root.left;
            root.left = root.right;
            root.right = backup;
            swapNodes(root.left);
            swapNodes(root.right);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        swapNodes(root);
        return root;
    }

    public static void main(String[] args) {
        InvertTree it = new InvertTree();
        TreeNode root = util.generateTreeFromArray(new int[] { 4, 2, 7, 1, 3, 6, 9 });
        it.invertTree(root);
    }
}
