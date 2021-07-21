package com.pearson.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode 1047
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString inString = new RemoveAllAdjacentDuplicatesInString();
        inString.removeAllAdjacentDuplicatesInString();
    }

    private void removeAllAdjacentDuplicatesInString() {
        System.out.println(removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(Character char1 : arr){
            if(!deque.isEmpty() && char1 == deque.peek()){
                deque.pop();
            } else {
                deque.push(char1);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
