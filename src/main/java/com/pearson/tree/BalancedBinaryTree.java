package com.pearson.tree;

/**
 * leetcoee 110
 * Created by peishen.nie on 2021/7/21.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        binaryTree.balancedBinaryTree();
    }

    private void balancedBinaryTree() {
        TreeNode node2 = new TreeNode(4, new TreeNode(3), new TreeNode(7));
        TreeNode node1 = new TreeNode(6, node2, new TreeNode(7));
        TreeNode node3 = new TreeNode(5, node1, new TreeNode(5));
        System.out.println(isBalanced(node3));
    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        helper(root);
        return flag;
    }

    public int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int r = helper(root.right) + 1;
        int l = helper(root.left) + 1;
        if(r - l > 1 || l - r > 1){
            flag = false;
        }
        return Math.max(r, l);
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
