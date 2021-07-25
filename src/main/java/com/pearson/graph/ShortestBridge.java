package com.pearson.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//leetcode 934
public class ShortestBridge {

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        shortestBridge.shortestBridge();
    }

    private void shortestBridge() {
        int[][] grid = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        System.out.println(shortestBridge(grid));
    }

    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new int[] { i, j });
                    break;
                }
            }
            if (list.size() == 1) {
                break;
            }
        }

        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < list.size(); x++) {
            int[] cur = list.get(x);
            int i = cur[0], j = cur[1];
            if (grid[i][j] == 1 && !visited[i][j]) {
                queue.offer(new int[] { i, j });
                visited[i][j] = true;
                set.add(i+""+j);
            }
            for (int[] dir : dirs) {
                int y = i + dir[0], z = j + dir[1];
                if (y < m && y >= 0 && z < n && z >= 0 && !visited[y][z] && grid[y][z] == 1) {
                    queue.offer(new int[] { y, z });
                    visited[y][z] = true;
                    list.add(new int[] { y, z });
                    set.add(y+""+z);
                }
            }
        }

        int cost = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                if (grid[i][j] == 1 && !set.contains(i+""+j)) {
                    return cost;
                }
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < m && x >= 0 && y < n && y >= 0 && !visited[x][y]) {
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return 0;
    }

    // 判断两个1是否是连接的
    private boolean isConnect(int[] a, int[] b) {
        if (a[0] == b[0] && (a[1] == b[1] + 1 || a[1] + 1 == b[1])) {
            return true;
        }
        if (a[1] == b[1] && (a[0] == b[0] + 1 || a[0] + 1 == b[0])) {
            return true;
        }

        return false;
    }
}
