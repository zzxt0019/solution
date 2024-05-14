package cn.leetcode.no_2201_2300.no_2244;

import java.util.HashMap;
import java.util.Map;

public class 完成所有任务需要的最少轮数 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, 1);
            } else {
                map.put(task, map.get(task) + 1);
            }
        }
        int time = 0;
        // 只能2或3,那么number=1则失败
        // num%3==0 (num/3)个3 0个2
        // num%3==1 (num/3-1)个3 2个2
        // num%3==2 (num/3)个3 1个2
        for (int number : map.values()) {
            if (number == 1) {
                return -1;
            }
            time += number / 3;
            if (number % 3 != 0) {
                time++;
            }
        }
        return time;
    }
}
