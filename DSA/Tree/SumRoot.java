//https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class SumRoot {
    int generateNum(TreeNode t, int val) {
        if (t == null) {
            return 0;
        }
        val = val * 10 + t.val;
        if (t.left == null && t.right == null) {
            return (val);
        }
        return generateNum(t.left, val) + generateNum(t.right, val);
    }

    public int sumNumbers(TreeNode root) {
        return generateNum(root, 0);
    }

    public static void main(String[] args) {
        SumRoot s = new SumRoot();
        TreeNode root = util.generateTreeFromArray(new int[] { 4, 9, 0, 5, 1 });
        System.out.println(s.sumNumbers(root));
        // s.sumNumbers(root);
    }
}
