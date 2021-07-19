package com.pearson.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 103
 * Created by peishen.nie on 2021/7/19.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
        traversal.binaryTreeZigzagLevelOrderTraversal();
    }

    public void binaryTreeZigzagLevelOrderTraversal(){
         TreeNode node1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
         TreeNode node2 = new TreeNode(9, null, null);
         TreeNode node3 = new TreeNode(3, node2, node1);
         System.out.println(zigzagLevelOrder(node3));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            flag = !flag;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                if(flag){
                    TreeNode node = linkedList.getLast();
                    linkedList.removeLast();
                    list.add(node.val);
                    if(null != node.left) {
                        linkedList.addFirst(node.left);
                    }
                    if(null != node.right) {
                        linkedList.addFirst(node.right);
                    }
                } else {
                    TreeNode node = linkedList.getFirst();
                    linkedList.removeFirst();
                    list.add(node.val);
                    if(null != node.right) {
                        linkedList.addLast(node.right);
                    }
                    if(null != node.left) {
                        linkedList.addLast(node.left);
                    }
                }
            }
            res.add(list);
        }
        return res;
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
