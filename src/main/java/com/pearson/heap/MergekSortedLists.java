package com.pearson.heap;

import java.util.PriorityQueue;

public class MergekSortedLists {
    
    public static void main(String[] args) {
        MergekSortedLists sortedLists = new MergekSortedLists();
        sortedLists.mergekSortedLists();
    }

    private void mergekSortedLists(){
        System.out.println(mergeKLists(new ListNode[]{new ListNode(1)}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(null != node){
                heap.offer(node);
            }
        }
        ListNode res = new ListNode(0), cur = res;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if(null != node.next){
                heap.offer(node.next);
            }
        }
        return res.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
