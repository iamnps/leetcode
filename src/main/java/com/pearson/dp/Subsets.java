package com.pearson.dp;

import java.util.ArrayList;
import java.util.List;

//leetcode 82
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subSets();
    }

    private void subSets() {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(res, nums, cur, index + 1);
        cur.remove(cur.size() - 1);

        dfs(res, nums, cur, index + 1);
    }
}
