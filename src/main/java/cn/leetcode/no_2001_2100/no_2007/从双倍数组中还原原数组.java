package cn.leetcode.no_2001_2100.no_2007;

import java.util.*;

public class 从双倍数组中还原原数组 {
    public static void main(String[] args) {
        int[] arr = {0,3,2,4,6,0};
        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : changed) {
            pq.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[changed.length / 2];
        int index = 0;
        while (pq.peek() != null) {
            int number = pq.poll();
            if (number % 2 == 0) {
                if (map.containsKey(number / 2)) {
                    if (map.get(number / 2) > 0) {
                        result[index++] = number / 2;
                        map.put(number / 2, map.get(number / 2) - 1);
                        continue;
                    }
                }
            }
            if (!map.containsKey(number)) {
                map.put(number, 0);
            }
            map.put(number, map.get(number) + 1);
        }
        if (index == result.length) {
            return result;
        } else {
            return new int[0];
        }
    }
}
