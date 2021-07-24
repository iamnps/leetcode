package com.pearson.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//leetcode 542
public class Matrix01 {

    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();
        matrix01.matrix01();
    }

    private void matrix01() {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        System.out.println(Arrays.toString(updateMatrix(mat)));
    }

    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        // 内层数组的长度是一致的才符合这种解法
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        // 已经访问过，计算出结果的值不能重复计算否则会影响结果，所以需要使用visited打上标记
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                if (mat[i][j] == 1) {
                    res[i][j] = cost;
                }

                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }

                }
            }
            cost++;
        }
        return res;
    }

}
