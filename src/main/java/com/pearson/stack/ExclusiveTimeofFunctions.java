package com.pearson.stack;

import java.util.*;

/**
 * leetcode 636
 * Created by peishen.nie on 2021/7/23.
 */
public class ExclusiveTimeofFunctions {

    public static void main(String[] args) {
        ExclusiveTimeofFunctions functions = new ExclusiveTimeofFunctions();
        functions.exclusiveTimeofFunctions();
    }

    private void exclusiveTimeofFunctions(){
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("1:start:7");
        list.add("1:end:7");
        list.add("0:end:8");
        System.out.println(Arrays.toString(exclusiveTime(2, list)));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        HashMap<String, Integer> hashMap = new HashMap<>();
        Deque<Helper> stack = new ArrayDeque<>();
        for (int i = 0; i < logs.size(); i++){
            String[] arr = logs.get(i).split(":");
            if(!stack.isEmpty()){
                Helper helper = stack.peek();
                int x = helper.t == 0 ? Integer.valueOf(arr[2]) : Integer.valueOf(arr[2]) - helper.t + 1;
                if(i == logs.size() - 1){
                    x = x == 0 ? 1 : x - 1;
                }
                if(arr[1].equals("start") && helper.type.equals("end")){
                    stack.addFirst(new Helper(arr[0], arr[1], Integer.valueOf(arr[2])));
                    continue;
                }
                String id = helper.type.equals("end") ? arr[0] : helper.id;
                hashMap.put(id, hashMap.getOrDefault(arr[0], 0) + x);
                if(helper.type.equals("start") && arr[1].equals("end") && helper.id.equals(arr[0])){
                    stack.pop();
                }
                if(helper.type.equals("end")){
                    stack.pop();
                }
            }
            stack.addFirst(new Helper(arr[0], arr[1], Integer.valueOf(arr[2])));
            if(!hashMap.containsKey(arr[0])){
                hashMap.put(arr[0], 0);
            }
        }
        int i = 0;
        for (String s : hashMap.keySet()){
            res[i] = hashMap.get(s);
            i++;
        }
        return res;
    }

    private class Helper{
        private String id;
        private int t;
        private String type;

        public Helper(String id, String type, int t){
            this.id = id;
            this.t = t;
            this.type = type;
        }
    }
}
