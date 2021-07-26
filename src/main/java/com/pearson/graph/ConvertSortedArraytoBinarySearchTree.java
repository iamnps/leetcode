package com.pearson.graph;

/**
 * leetcode 108 Created by peishen.nie on 2021/7/26.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree tree = new ConvertSortedArraytoBinarySearchTree();
        tree.convertSortedArraytoBinarySearchTree();
    }

    private void convertSortedArraytoBinarySearchTree() {
        sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, i, j - 1);
        node.right = helper(nums, i + 1, j);

        return node;
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
