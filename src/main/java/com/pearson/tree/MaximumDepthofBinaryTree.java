package com.pearson.tree;

//leecode 104
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        MaximumDepthofBinaryTree max = new MaximumDepthofBinaryTree();
        max.maximumDepthofBinaryTree();
    }

    public void maximumDepthofBinaryTree() {
        TreeNode node1 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node3 = new TreeNode(1, node1, new TreeNode(2));
        System.out.println(maxDepth(node3));
    }

    // 递归方法，查询深度，先解析最深处，再一层一层返回
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int max = l < r ? r : l;// 此处如果是选小的值就是看二叉树的最浅深度，这样会把整个解析完
        return max + 1;
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
