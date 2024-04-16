package cn.leetcode.no_1_100.no_41;

import java.util.*;

public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 3, 5, 4};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                if (set.add(num)) {
                    pq.offer(num);
                }
            }
        }
        Integer poll;
        int result = 1;
        while ((poll = pq.poll()) != null) {
            if (poll == result) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }

    private static class UF {
        private final Map<Integer, Integer> map = new HashMap<>();

        public boolean contains(int a) {
            return map.containsKey(a);
        }

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
            if (map.get(a) != a) {
                int root = find(map.get(a));
                map.put(a, root);
            }
            return map.get(a);
        }

    }
}
