package cn.leetcode.no_128;

import java.util.PriorityQueue;

public class 最长连续序列 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));

    }

    public static int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        Integer next;
        int last = -2;
        int count = Integer.MAX_VALUE;
        int max = 1;
        while ((next = pq.poll()) != null) {
            if (next == last) {  // 相同
                continue;
            }
            if (next == last + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            last = next;
        }
        max = Math.max(max, count);
        return max;
    }
}
