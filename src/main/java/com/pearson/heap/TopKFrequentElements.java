package com.pearson.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

//leetcode 347
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements elements = new TopKFrequentElements();
        elements.topKFrequentElements();
    }

    private void topKFrequentElements() {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5 }, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        // 这种思路是出现次数较少的在最上面有出现次数更多的会被踢出去
        // 还有有一种思路，把大的放最上面，在添加到结果的arr中时，只拿前k个值就好了就是正确结果了
        PriorityQueue<Helper> heap = new PriorityQueue<>((a, b) -> a.b - b.b);
        Set<Integer> set = hashMap.keySet();
        for (Integer i : set) {
            Helper helper = new Helper(i, hashMap.get(i));
            if (heap.size() < k || hashMap.get(i) > heap.peek().b) {
                heap.offer(helper);
            }
            if (k < heap.size()) {
                heap.poll();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll().a;
        }
        return arr;
    }

    private class Helper {
        private int a;
        private int b;

        Helper(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
