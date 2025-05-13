//https://leetcode.com/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null
                && (targetSum - root.val == 0))
            return true;

        return hasPathSum(root.left, root.val - targetSum) || hasPathSum(root.right, root.val - targetSum);
    }

    public static void main(String[] args) {

    }
}
