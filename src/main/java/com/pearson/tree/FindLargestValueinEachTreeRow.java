package com.pearson.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 515
 * Created by peishen.nie on 2021/7/19.
 */
public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer x = null;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(null == x){
                    x = node.val;
                }
                x = x < node.val ? node.val : x;
                if(null != node.right) {
                    queue.offer(node.right);
                }
                if(null != node.left) {
                    queue.offer(node.left);
                }
            }
            res.add(x);
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
