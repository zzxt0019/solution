package cn.leetcode.no_2401_2500.no_2462;

import java.util.PriorityQueue;

public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        int[] costs = {18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75};
        int k = 13;
        int candidates = 23;
        System.out.println(totalCost(costs, k, candidates));

    }

    public static long totalCost(int[] costs, int k, int candidates) {
        // 处理main()中的情况
        if (costs.length <= candidates * 2) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0;
            for (int cost : costs) {
                pq.add(cost);
            }
            for (int i = 0; i < k; i++) {
                sum += pq.poll();
            }
            return sum;
        }
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            left.add(costs[i]);
            right.add(costs[costs.length - i - 1]);
        }
        int count = 0;
        long sum = 0;
        int leftIndex = candidates;
        int rightIndex = costs.length - candidates - 1;
        while (count < k && leftIndex <= rightIndex) {
            if (left.peek() > right.peek()) {
                sum += right.poll();
                right.add(costs[rightIndex--]);
            } else {
                sum += left.poll();
                left.add(costs[leftIndex++]);
            }
            count++;
        }
        while (count < k) {
            if (left.peek() == null) {
                sum += right.poll();
            } else if (right.peek() == null) {
                sum += left.poll();
            } else {
                if (left.peek() > right.peek()) {
                    sum += right.poll();
                } else {
                    sum += left.poll();
                }
            }
            count++;
        }
        return sum;
    }
}
