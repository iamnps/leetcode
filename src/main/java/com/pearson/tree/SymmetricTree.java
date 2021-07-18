package com.pearson.tree;
//leetcode 101
public class SymmetricTree {
 
    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return false;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(right == null && left == null){
            return true;
        } else if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return helper(left.left, right.right) && helper(right.left, left.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }   
    }
 
}
