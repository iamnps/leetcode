package com.pearson.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 429
 * Created by peishen.nie on 2021/7/19.
 */
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal traversal = new NaryTreeLevelOrderTraversal();
        traversal.naryTreeLevelOrderTraversal();
    }

    public void naryTreeLevelOrderTraversal(){
        List<Node> nodes3 = new ArrayList<>();
        nodes3.add(new Node(30));
        nodes3.add(new Node(31));
        nodes3.add(new Node(32));

        List<Node> nodes41 = new ArrayList<>();
        nodes41.add(new Node(410));
        nodes41.add(new Node(411));
        nodes41.add(new Node(412));

        Node node41 = new Node(41);
        node41.children = nodes41;

        List<Node> nodes4 = new ArrayList<>();
        nodes4.add(new Node(40));
        nodes4.add(node41);

        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node3.children = nodes3;
        Node node4 = new Node(4);
        node4.children = nodes4;
        Node node5 = new Node(5);
        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        node.children = nodes;
        System.out.println(levelOrder(node));
    }

    public List<List<Integer>> levelOrder(Node root) {
        if(null == root){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node.val);
                if(null != node.children && 0 != node.children.size()){
                    queue.addAll(node.children);
                }
            }
            res.add(list);
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
