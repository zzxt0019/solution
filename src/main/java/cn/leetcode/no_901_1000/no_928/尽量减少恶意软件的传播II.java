package cn.leetcode.no_901_1000.no_928;

import cn.leetcode.utils.ArrayUtil;

import java.util.*;

public class 尽量减少恶意软件的传播II {
    public static void main(String[] args) {
        int[][] graph = ArrayUtil.toIntArray2("[[1,1,0],[1,1,1],[0,1,1]]");
        System.out.println(minMalwareSpread(graph,
                new int[]{0, 1}));
    }

    /**
     * 参考238
     */
    public static int minMalwareSpread(int[][] graph, int[] initial) {

        UF[] ufs1 = new UF[graph.length];  // 第1次     1       ①       ①②     ①②③   ①②③④
        UF[] ufs2 = new UF[graph.length];  // 第2次  ②③④⑤   ③④⑤     ④⑤       ⑤       1
        UF[] ufs = new UF[graph.length];   // 总     ②③④⑤  ①③④⑤  ①②④⑤   ①②③⑤  ①②③④
        for (int i = 0; i < graph.length; i++) {
            UF uf = new UF();
            ufs1[i] = uf;
            if (i > 0) {
                uf.map.putAll(ufs1[i - 1].map);  // 继承前面的"乘法"
                for (int j = 0; j < i; j++) {
                    if (graph[i - 1][j] == 1) {
                        uf.union(i - 1, j);  // 将新加的"乘"前面每一个
                    }
                }
            }
        }
        for (int i = graph.length - 1; i >= 0; i--) {
            UF uf = new UF();
            ufs2[i] = uf;
            if (i < graph.length - 1) {
                uf.map.putAll(ufs2[i + 1].map);
                for (int j = graph.length - 1; j > i; j--) {
                    if (graph[i + 1][j] == 1) {
                        uf.union(i + 1, j);
                    }
                }
            }
        }
        for (int i = 0; i < ufs.length; i++) {
            UF uf = new UF();
            ufs[i] = uf;
            uf.map.putAll(ufs1[i].map);  // 继承1的结果
            uf.map.putAll(ufs2[i].map);  // 继承2的结果
            for (int j = 0; j < i; j++) {
                for (int k = graph.length - 1; k > i; k--) {
                    if (graph[j][k] == 1) {
                        uf.union(j, k);  // 将1和2的交叉"相乘"
                    }
                }
            }
        }
        // uf[] 为去掉index的并查集
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : initial) {
            pq.add(i);
        }
        Iterator<Integer> iterator = pq.iterator();
        int maxCount = 0;
        int result = pq.peek();
        while (iterator.hasNext()) {
            int deleted = iterator.next();
            Set<Integer> bingoRootSet = new HashSet<>();
            for (int index : initial) {
                if (index != deleted) {  // 没有去掉的, 添加到bingoRootSet, 意思是这个root被感染
                    bingoRootSet.add(ufs[deleted].find(index));
                }
            }
            int saveCount = 0;
            for (int i = 0; i < graph.length; i++) {
                if (!bingoRootSet.contains(ufs[deleted].find(i))) {  // root不在set里, 说明当前这个没被感染
                    saveCount++;
                }
            }
            if (saveCount > maxCount) {
                maxCount = saveCount;
                result = deleted;
            }
        }
        return result;
    }

    private static class UF {
        private Map<Integer, Integer> map = new HashMap<>();

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot != bRoot) {
                map.put(aRoot, bRoot);
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
    }
}
