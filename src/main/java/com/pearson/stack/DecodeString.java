package com.pearson.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 394 Created by peishen.nie on 2021/7/23.
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString();

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
        hashMap.computeIfAbsent(2, k -> new ArrayList<>()).add(3);
        hashMap.computeIfAbsent(1, k -> new ArrayList<>()).add(3);
        System.out.println(hashMap);
    }

    private void decodeString() {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        int a = 0;
        for (Character c : arr) {
            int code = c.hashCode();
            if (code == 91) {
                a++;
            }
            if (!stack.isEmpty() && code == 93) {
                int x = 0;
                a--;
                Deque<Character> stack1 = new ArrayDeque<>();
                String str = "";
                while (!stack.isEmpty()) {
                    Character temp = stack.peek();
                    if (isInt(temp.hashCode())) {
                        str = temp.toString() + str;
                        stack.pop();
                        x = Integer.valueOf(str);
                        continue;
                    }
                    if (x != 0) {
                        break;
                    }
                    if (temp.hashCode() != 91) {
                        stack1.addFirst(temp);
                    }
                    stack.pop();
                }
                while (x != 0) {
                    for (Character temp : stack1) {
                        stack.addFirst(temp);
                    }
                    x--;
                }
                stack1.clear();
                if (a == 0) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pollLast());
                    }
                    stack.clear();
                }
            }

            if (!isInt(code) && code != 91 && code != 93 && stack.isEmpty()) {
                sb.append(c);
            } else if (code != 93) {
                stack.addFirst(c);
            }
        }
        return sb.toString();
    }

    private boolean isInt(int code) {
        return code < 58 && code > 47;
    }

}
