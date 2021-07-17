package com.pearson.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    
    public static void main(String[] args) {
        /* System.out.println("ArrayList makeList1 start: " + System.currentTimeMillis());
        makeList1(new ArrayList<>(), 10000);
        System.out.println("ArrayList makeList1 stop: " + System.currentTimeMillis());

        System.out.println("LinkedList makeList1 start: " + System.currentTimeMillis());
        makeList1(new LinkedList(), 10000);
        System.out.println("LinkedList makeList1 stop: " + System.currentTimeMillis());

        System.out.println("ArrayList makeList2 start: " + System.currentTimeMillis());
        makeList2(new ArrayList<>(), 10000);
        System.out.println("ArrayList makeList2 stop: " + System.currentTimeMillis());

        System.out.println("LinkedList makeList2 start: " + System.currentTimeMillis());
        makeList2(new LinkedList(), 10000);
        System.out.println("LinkedList makeList2 stop: " + System.currentTimeMillis()); */

        System.out.println("ArrayList sum start: " + System.currentTimeMillis());
        sum(makeList1(new ArrayList<>(), 10000));
        System.out.println("ArrayList sum stop: " + System.currentTimeMillis());

        System.out.println("LinkedList sum start: " + System.currentTimeMillis());
        sum(makeList1(new ArrayList<>(), 10000));
        System.out.println("LinkedList sum stop: " + System.currentTimeMillis());

    }    

    private static List<Integer> makeList1(List<Integer> lst, int n){
        for(int i = 0; i < n; i++){
            lst.add(i);
        }

        return lst;
    }

    private static void makeList2(List<Integer> lst, int n){
        for(int i = 0; i < n; i++){
            lst.add(0, i);
        }
    }

    private static void sum(List<Integer> lst){
        int total = 0;
        for(int i = 0; i < lst.size(); i++){
            total += lst.get(i);
        }
    }

}
