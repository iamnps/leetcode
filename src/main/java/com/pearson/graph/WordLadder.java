package com.pearson.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//leetcode 127
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        wordLadder.wordLadder();
    }

    private void wordLadder() {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 如果endWord不存在于list中则直接返回0，因为不可能找到
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 如果beginWord不存在于list中则添加进去
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        // 根据给定list生成需要的graph
        HashMap<String, List<String>> graph = construnctGraph(wordList);
        Set<String> visited = new HashSet<>();// 用来标记字符串是否已经被用过，因为这个graph肯定是互相相连且没有方向的
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);
        // beginword到endword最少需要一步，改变一个字符
        int cost = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 取出待选字符看看是否与endword相等，相等则返回
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return cost;
                }
                // 根据待选字符，选出此字符可变成的字符，然后将没有使用过的字符加入stack
                for (String neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            cost++;
        }
        return 0;
    }

    // 使用题目中提出的规则，对list中的字符串进行构图，将字符串A能换一个字母就变成的新字符串建立上连接关系
    private HashMap<String, List<String>> construnctGraph(List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String w1 = wordList.get(i), w2 = wordList.get(j);
                graph.computeIfAbsent(w1, k -> new ArrayList<>()).add(w2);
                graph.computeIfAbsent(w2, k -> new ArrayList<>()).add(w1);
            }
        }
        return graph;
    }

    // 这个方法用来比较两个字符串是否是只有一个字符不一样
    private boolean oneChangeAway(String w1, String w2) {
        int diff = 0;
        // 默认比较的两个字符串的长度一致
        for (int i = 0; i < w1.length(); i++) {
            // 遍历字符串，对字符串的每一位字符进行比较，如果两个字符串有字符不一样，则diff++
            char c1 = w1.charAt(i), c2 = w2.charAt(i);
            if (c1 != c2) {
                diff++;
            }
        }
        // 因为规则是两个字符串之间只有一个字符不一样，所以如果diff等于1说明符合条件，反之则不符合
        return diff == 1;
    }
}
