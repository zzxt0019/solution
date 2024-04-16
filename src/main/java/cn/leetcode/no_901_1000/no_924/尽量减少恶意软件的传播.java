package cn.leetcode.no_901_1000.no_924;

import cn.leetcode.utils.ArrayUtil;

import java.util.*;

public class 尽量减少恶意软件的传播 {
    public static void main(String[] args) {
        System.out.println(minMalwareSpread(ArrayUtil.toIntArray2("[[1,0,0,0,1,0,0,0,0,0,1],[0,1,0,1,0,0,0,0,0,0,0],[0,0,1,0,0,0,0,1,0,0,0],[0,1,0,1,0,1,0,0,0,0,0],[1,0,0,0,1,0,0,0,0,0,0],[0,0,0,1,0,1,0,0,1,1,0],[0,0,0,0,0,0,1,1,0,0,0],[0,0,1,0,0,0,1,1,0,0,0],[0,0,0,0,0,1,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,1,0],[1,0,0,0,0,0,0,0,0,0,1]]"),
                new int[]{7, 8, 6, 2, 3}));

    }

    public static int minMalwareSpread(int[][] graph, int[] initial) {
        UF uf = new UF();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // key: root, value: count
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x : initial) {
            pq.add(x);
            int root = uf.find(x);
            if (!countMap.containsKey(root)) {
                countMap.put(root, 0);
            }
            countMap.put(root, countMap.get(root) + 1);
        }
        int number = pq.peek();
        int maxSize = 0;
        for (Integer x : pq) {
            int root = uf.find(x);
            if (countMap.get(root) == 1) {
                int size = uf.size(x);
                if (maxSize < size) {
                    maxSize = size;
                    number = x;
                }
            }
        }
        return number;
    }

    private static class UF {
        private final Map<Integer, Integer> map = new HashMap<>();
        private final Map<Integer, Integer> sizeMap = new HashMap<>();

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot != bRoot) {
                map.put(aRoot, bRoot);
                sizeMap.put(bRoot, sizeMap.getOrDefault(aRoot, 1) + sizeMap.getOrDefault(bRoot, 1));
            }
        }

        public boolean check(int a, int b) {
            return find(a) == find(b);
        }

        public int find(int a) {
            if (!map.containsKey(a)) {
                map.put(a, a);
            }
            if (a != map.get(a)) {
                map.put(a, find(map.get(a)));
            }
            return map.get(a);
        }

        public int size(int a) {
            return sizeMap.getOrDefault(find(a), 1);
        }
    }
}
