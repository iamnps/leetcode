package com.pearson.tree;

/**
 * leetcode 236
 * Created by peishen.nie on 2021/7/21.
 */
public class LowestCommonAncestorofaBinaryTree {

    public static void main(String[] args) {
        LowestCommonAncestorofaBinaryTree binaryTree = new LowestCommonAncestorofaBinaryTree();
        binaryTree.lowestCommonAncestorofaBinaryTree();
    }

    private void lowestCommonAncestorofaBinaryTree(){
        TreeNode node2 = new TreeNode(4, new TreeNode(3), new TreeNode(7));
        TreeNode node1 = new TreeNode(6, node2, new TreeNode(2));
        TreeNode node3 = new TreeNode(5, node1, new TreeNode(1));
        TreeNode t = lowestCommonAncestor(node3, new TreeNode(3), new TreeNode(7));
        System.out.println(null == t ? "error" : t.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode l = root.left != null ? lowestCommonAncestor(root.left, p, q) : null;
        TreeNode r = root.right != null ? lowestCommonAncestor(root.right, p, q) : null;
        if((l != null || r != null) && (root.val == p.val || root.val == q.val)){
            return root;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(l != null && r != null){
            return root;
        }
        if(l != null){
            return l;
        }
        if(r != null){
            return r;
        }
        return null;
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
