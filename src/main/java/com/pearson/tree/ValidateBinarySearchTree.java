package com.pearson.tree;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree binarySearchTree = new ValidateBinarySearchTree();
        binarySearchTree.validateBinarySearchTree();
    }

    private void validateBinarySearchTree() {
        TreeNode node1 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode node2 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(5, new TreeNode(5), new TreeNode(5));
        System.out.println(isValidBST(node3));
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root.left && null == root.right) {
            return true;
        }
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, Long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, root.val * 1L, min) && helper(root.right, max, root.val * 1L);
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
