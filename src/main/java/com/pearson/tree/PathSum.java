package com.pearson.tree;

//leetcode 112
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        pathSum.pathSum();
    }

    private void pathSum(){
        TreeNode node1 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node3 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(hasPathSum(node3, 1));
    }

    private boolean flag = false;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return flag;
    }

    private boolean helper(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        helper(root.left, targetSum);
        helper(root.right, targetSum);
        if(null == root.left && null == root.right && targetSum == 0){
            flag = true;
        }  
        return false;
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
