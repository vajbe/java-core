//https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1646703285/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return root != null ? 1 + Math.max(maxDepth(root.left), maxDepth(root.right)) : 0;
    }

    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();
        TreeNode root = util.generateTreeFromArray(new int[] { 3, 9, 20, 0, 0, 15, 7 });
        md.maxDepth(root);
    }
}
