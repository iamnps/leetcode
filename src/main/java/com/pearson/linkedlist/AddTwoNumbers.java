package com.pearson.linkedlist;

//leetcode 2
public class AddTwoNumbers {

    // 查找node中的值然后相加，如果大于10则进一位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;// 进位标识值
        ListNode dummy = new ListNode(0), cur = dummy;
        while (null != l1 || null != l2) {
            int sum = carry;// 每次都先把上一次相加的要进位值给过来
            if (null != l1) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);// 也只是存储个位大于10需进位，所以用mod
            cur = cur.next;
            carry = sum / 10;// 保证进位值传递
        }
        if (carry > 0) {// 如果都加完了carry还大于0则说明还要进一位，则在最后加上
            cur.next = new ListNode(carry);
        }
        return dummy.next;
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
