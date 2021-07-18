package com.pearson.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//leetcode 111
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        MinimumDepthofBinaryTree tree = new MinimumDepthofBinaryTree();
        tree.MinimumDepthofBinaryTree();

    }

    public void MinimumDepthofBinaryTree() {
        // TreeNode node = new TreeNode(4, new TreeNode(5), new TreeNode(6));
        // TreeNode node1 = new TreeNode(1, node, new TreeNode(5));
        // TreeNode node2 = new TreeNode(1, node1, node);
        // TreeNode node3 = new TreeNode(1, node, node2);
        // System.out.println(minDepth(node3));

        // TreeNode node = new TreeNode(4, new TreeNode(5), new TreeNode(5));
        // System.out.println(minDepth(node));

        TreeNode node1 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node3 = new TreeNode(1, node1, new TreeNode(2));
        System.out.println(minDepth(node3));
    }

    public int minDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int x = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            x++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(null == node.left && null == node.right){
                    return x;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
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
