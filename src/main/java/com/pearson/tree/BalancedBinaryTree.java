package com.pearson.tree;


public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        binaryTree.balancedBinaryTree();
    }

    private void balancedBinaryTree() {
        TreeNode node1 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode node2 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(5, new TreeNode(5), new TreeNode(5));
        System.out.println(isBalanced(node3));
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root.left && null == root.right) {
            return true;
        }
        helper(root, true, false);

        return false;
    }

    public int helper(TreeNode root, boolean flag) {
        if (null == root) {
            return 0;
        }
        int x = 1;
        if (flag) {
            x = helper(root.left, flag) + 1;
        }

        return x;
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
