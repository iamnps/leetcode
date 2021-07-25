package com.pearson.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//leetcode 915
public class PartitionArrayintoDisjointIntervals {

    public static void main(String[] args) {
        PartitionArrayintoDisjointIntervals intervals = new PartitionArrayintoDisjointIntervals();
        intervals.partitionArrayintoDisjointIntervals();
    }

    private void partitionArrayintoDisjointIntervals() {
        System.out.println(partitionDisjoint(new int[] { 3, 1, 8, 4, 9, 7, 12, 0, 0, 12, 6, 12, 6, 19, 24, 90, 87, 54,
                92, 60, 31, 59, 75, 90, 20, 38, 52, 51, 74, 70, 86, 20, 27, 91, 55, 47, 54, 86, 15, 16, 74, 32, 68, 27,
                19, 54, 13, 22, 34, 74, 76, 50, 74, 97, 87, 42, 58, 95, 17, 93, 39, 33, 22, 87, 96, 90, 71, 22, 48, 46,
                37, 18, 17, 65, 54, 82, 54, 29, 27, 68, 53, 89, 23, 12, 90, 98, 42, 87, 91, 23, 72, 35, 14, 58, 62, 79,
                30, 67, 44, 48 }));
    }

    public int partitionDisjoint(int[] nums) {
        System.out.println(System.currentTimeMillis());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);// 如果值相等则下标较小的在前
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[] { i, nums[i] });
        }
        System.out.println(System.currentTimeMillis());
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll()[0];
            i = x > i ? x : i;
            set.add(x);
            if (set.size() == i + 1 && isTrue(set)) {
                return set.size();
            }
        }

        return 0;
    }

    private boolean isTrue(Set<Integer> set) {
        int i = -1;
        for (int x : set) {
            if (x == i + 1) {
                i = x;
            } else {
                return false;
            }
        }
        return true;
    }
}
