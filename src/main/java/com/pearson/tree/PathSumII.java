package com.pearson.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * leetcode 113 Created by peishen.nie on 2021/7/21.
 */
public class PathSumII {

    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSumII();
    }

    private void pathSumII() {
        TreeNode node1 = new TreeNode(7, new TreeNode(3), new TreeNode(4));
        TreeNode node2 = new TreeNode(8, new TreeNode(3), new TreeNode(3));
        TreeNode node3 = new TreeNode(5, node1, node2);
        System.out.println(pathSum(node3, 16));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<LinkedList<Integer>> linkedList = helper(root, targetSum);
        for (LinkedList<Integer> link : linkedList) {
            List<Integer> list = new ArrayList<>(link);
            rs.add(list);
        }
        return rs;
    }

    public LinkedList<LinkedList<Integer>> helper(TreeNode root, int targetSum) {
        targetSum = targetSum - root.val;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        if (0 == targetSum && null == root.right && null == root.left) {
            LinkedList<Integer> l = new LinkedList<>();
            l.addFirst(root.val);
            list.add(l);
            return list;
        }
        LinkedList<LinkedList<Integer>> l = root.left != null ? helper(root.left, targetSum) : null;
        if (l != null) {
            for (LinkedList<Integer> ls : l) {
                ls.addFirst(root.val);
                list.add(ls);
            }
        }
        LinkedList<LinkedList<Integer>> r = root.right != null ? helper(root.right, targetSum) : null;
        if (r != null) {
            for (LinkedList<Integer> ls : r) {
                ls.addFirst(root.val);
                list.add(ls);
            }
        }
        return list;
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
