package cn.leetcode.no_801_900.no_857;

import java.util.*;

public class 雇佣K名工人的最低成本 {
    public static void main(String[] args) {
        int[] quality = {1};
        int[] wage = {1};
        int k = 1;
//        int[] quality = {10, 20, 5};
//        int[] wage = {70, 50, 30};
//        int k = 2;
//        int[] quality = {39, 79, 78, 16, 6, 36, 97, 79, 27, 14, 31, 4, 36, 2, 61, 30, 74, 35, 65, 31};
//        int[] wage = {213, 456, 71, 53, 110, 376, 403, 273, 358, 457, 47, 427, 123, 316, 140, 60, 213, 48, 269, 132};
//        int k = 4;
        System.out.println(mincostToHireWorkers(quality, wage, k));

    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 先通过wq排序, 同时将quality和wage按照wq的顺序排成新的q和w
        double[] wq = new double[quality.length];
        Map<Double, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < quality.length; i++) {
            wq[i] = (double) wage[i] / quality[i];
            if (!map.containsKey(wq[i])) {
                map.put(wq[i], new ArrayList<>());
            }
            map.get(wq[i]).add(i);
        }
        int[] q = new int[quality.length];
        int[] w = new int[wage.length];
        Arrays.sort(wq);
        int arrIndex = 0;
        for (int i = 0; i < wq.length; i++) {
            if (i == 0 || wq[i] != wq[i - 1]) {
                List<Integer> list = map.get(wq[i]);
                for (Integer index : list) {
                    w[q.length - 1 - arrIndex] = wage[index];
                    q[q.length - 1 - arrIndex] = quality[index];
                    arrIndex++;
                }
            }
        }
        // 现在的q和w的顺序是 w/q小的在前面,
        // 因此, 如果以index为底(按照他给最低工资, 其余人的工资不按照最低工资给, 按照"比例"给)的情况,
        //       左边的不考虑, 右边的才会算(index左边的最低工资比"比例"高)
        // minQ[index]表示q[index]右边(k-1)个数之和的最小值, 这个数就是按"比例"的数
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] minQ = new int[q.length + 1];
        for (int i = q.length - 1; i >= 0; i--) {
            pq.add(q[i]);
            if (pq.size() < k ) {
                minQ[i] = minQ[i + 1] + q[i];
            } else {
                if (q[i] < pq.peek()) {
                    minQ[i] = minQ[i + 1] + q[i] - pq.poll();
                } else {
                    pq.poll();
                    minQ[i] = minQ[i + 1];
                }
            }
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < q.length; i++) {
            min = Math.min(cost(q, w, k, i, minQ), min);
        }
        return min;
    }

    private static double cost(int[] quality, int[] wage, int k, int index, int[] maxQ) {
        if (quality.length - index < k) {
            return Double.MAX_VALUE;
        }
        return wage[index] + (double) maxQ[index + 1] * wage[index] / quality[index];
    }
}
