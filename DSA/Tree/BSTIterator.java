package DSA.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftToBranch(root);
    }

    void pushLeftToBranch(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            pushLeftToBranch(node.right);
        }
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
