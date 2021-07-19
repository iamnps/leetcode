package com.pearson.tree;
import java.util.Set;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum sum = new BinaryTreeMaximumPathSum();
        sum.binaryTreeMaximumPathSum();
    }

    private void binaryTreeMaximumPathSum() {
        TreeNode node1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode node3 = new TreeNode(-2, new TreeNode(1), null);
        maxPathSum(node3);
        System.out.println(max);
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int r = maxPathSum(root.right);
        int l = maxPathSum(root.left);
        r = r > 0 ? r : 0;
        l = l > 0 ? l : 0;
        max = Math.max(max, root.val + r +l);
        return Math.max(root.val + r, root.val + l);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
