// https://leetcode.com/problems/same-tree/?envType=study-plan-v2&envId=top-interview-150
package DSA.Tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q != null && p.val != q.val) ||
                (p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {
        SameTree sm = new SameTree();
        TreeNode p = util.generateTreeFromArray(new int[] { 1, 2, 3 });
        TreeNode q = util.generateTreeFromArray(new int[] { 1, 2, 3 });
        System.out.println("Is Equal: " + sm.isSameTree(p, q));
    }
}
