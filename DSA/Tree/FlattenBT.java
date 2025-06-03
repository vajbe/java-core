//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class FlattenBT {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                TreeNode anscestor = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = anscestor;
                current.left = null;
            }
            current = current.right;
        }
    }
}
