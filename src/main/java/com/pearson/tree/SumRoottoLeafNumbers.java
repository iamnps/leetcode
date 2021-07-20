package com.pearson.tree;

public class SumRoottoLeafNumbers {

    public static void main(String[] args) {
        SumRoottoLeafNumbers numbers = new SumRoottoLeafNumbers();
        numbers.sumRoottoLeafNumbers();
    }


    public void sumRoottoLeafNumbers() {       
        TreeNode node1 = new TreeNode(2, new TreeNode(5), new TreeNode(7));
         TreeNode node2 = new TreeNode(9, new TreeNode(1), new TreeNode(2));
         TreeNode node3 = new TreeNode(3, node2, node1);
        System.out.println(sumNumbers(node3, 0));
    }

    public int sumNumbers(TreeNode root, int ax) {
        if(null == root){
            return 0;
        }
        if(null == root.left && null == root.right){
            return root.val + ax;
        }
        ax = root.val * 10 + ax * 10;
        int l = sumNumbers(root.left, ax);
        int r = sumNumbers(root.right, ax);
        return l+r;
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
