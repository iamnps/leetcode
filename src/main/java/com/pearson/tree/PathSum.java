package com.pearson.tree;

//leetcode 112
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        pathSum.pathSum();
    }

    private void pathSum(){
        TreeNode node1 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node3 = new TreeNode(1, node1, new TreeNode(2));
        System.out.println(hasPathSum(node3, 3));
    }

    private int a = 0;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        hasPathSum(root.left, targetSum);
        hasPathSum(root.right, targetSum);
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
