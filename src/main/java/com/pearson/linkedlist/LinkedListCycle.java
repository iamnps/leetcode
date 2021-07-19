package com.pearson.linkedlist;

//leetcode 141
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.LinkedListCycle();
    }

    public void LinkedListCycle() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);
        listNode5.next = listNode1;

        System.out.println(cycle(listNode5));
    }

    // 因为有环则肯定会相遇，所以这种解法一定是可以的
    private static boolean cycle(ListNode head) {
        if (head == null || null == head.next) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
