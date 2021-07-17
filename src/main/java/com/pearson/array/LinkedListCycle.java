package com.pearson.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCycle {

    public static void main(String[] args) {
    
        LinkedList linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        
        

        Iterator<LinkedList> iter  = linkedList.iterator();
        while(iter.hasNext()){

        }
        
    }


    private class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    
}
