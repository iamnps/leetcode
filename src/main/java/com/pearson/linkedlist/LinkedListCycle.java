package com.pearson.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//leetcode 141
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.LinkedListCycle();
    }

    public void LinkedListCycle(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode5.next = listNode1;

        System.out.println(cycle(listNode5));
    }


    private static boolean cycle(ListNode head){
        if(head == null || null == head.next){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }


    
}
