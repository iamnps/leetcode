package com.pearson.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 20 Created by peishen.nie on 2021/7/22.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.validParentheses();
    }

    private void validParentheses() {
        System.out.println(isValid("([{}])"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        for (Character str : arr) {
            int code = str.hashCode();
            if (!deque.isEmpty() && ((code == 41 && deque.peek() == 40) || (code == 93 && deque.peek() == 91)
                    || (code == 125 && deque.peek() == 123))) {
                deque.pop();
            } else {
                deque.push(code);
            }
        }

        return deque.isEmpty();
    }

}
