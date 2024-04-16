package cn.leetcode.no_201_300.no_239;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 滑动窗口最大值 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = pq.peek();
        Map<Integer, Integer> deleteCountMap = new HashMap<>();
        for (int i = 1; i <= nums.length - k; i++) {
            int deleteNum = nums[i - 1];
            if (!deleteCountMap.containsKey(deleteNum)) {
                deleteCountMap.put(deleteNum, 0);
            }
            deleteCountMap.put(deleteNum, deleteCountMap.get(deleteNum) + 1);
            pq.add(nums[i + k-1]);
            result[i] = findUsableNumber(deleteCountMap, pq);
        }
        return result;
    }

    private static int findUsableNumber(Map<Integer, Integer> deleteCountMap, PriorityQueue<Integer> pq) {
        while (true) {
            int number = pq.peek();
            if (!deleteCountMap.containsKey(number) || deleteCountMap.get(number) == 0) {
                return number;
            }
            pq.poll();
            deleteCountMap.put(number, deleteCountMap.get(number) - 1);
        }
    }
}
