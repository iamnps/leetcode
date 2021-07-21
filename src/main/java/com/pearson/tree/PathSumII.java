package com.pearson.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 113
 * Created by peishen.nie on 2021/7/21.
 */
public class PathSumII {

    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSumII();
    }

    private void pathSumII(){
        TreeNode node1 = new TreeNode(7, new TreeNode(3), new TreeNode(4));
        TreeNode node2 = new TreeNode(8, new TreeNode(3), new TreeNode(3));
        TreeNode node3 = new TreeNode(5, node1, node2);
        System.out.println(pathSum(node3, 16));
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(null == root){
            return null;
        }
        if(null != root.left){
            List<Integer> l = helper(root.left, targetSum - root.val);
            if(null != l){
                l.add(root.val);
                res.add(l);
            }

        }
        if(null != root.right){
            List<Integer> r = helper(root.right, targetSum - root.val);
            if(null != r){
                r.add(root.val);
                res.add(r);
            }
        }
        return res;
    }

    private List<Integer> helper(TreeNode root, int targetSum){
        targetSum = targetSum - root.val;
        if(0 == targetSum && null == root.right && null == root.left){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }
        List<Integer> l = root.left != null ? helper(root.left, targetSum) : null;
        if(l != null){
            l.add(root.val);
            return l;
        }
        List<Integer> r = root.right != null ? helper(root.right, targetSum) : null;
        if(r != null){
            r.add(root.val);
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
