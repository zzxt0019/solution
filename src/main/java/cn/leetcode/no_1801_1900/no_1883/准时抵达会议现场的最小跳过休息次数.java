package cn.leetcode.no_1801_1900.no_1883;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 准时抵达会议现场的最小跳过休息次数 {
    public static void main(String[] args) {
        System.out.println(minSkips(new int[]{18,66,64,12,97,7,15,20,81,21,88,55,77,9,50,49,77,60,68,33,71,2,88,93,15,88,69,97,35,99,83,44,15,38,56,21,59,1,93,93,34,65,98,23,65,14,81,39,82,65,78,26,20,48,98,21,70,100,68,1,77,42,63,3}, 17,160));

    }

    public static int minSkips(int[] dist, int speed, int hoursBefore) {
        long[][][] dp = new long[dist.length + 1][dist.length][2];
        for (long[][] arr : dp) {
            for (long[] two : arr) {
                two[0] = 10000000;
                two[1] = 1;
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            long[] time0 = {dist[i - 1], speed};
            dp[i][0] = new long[]{divide(add(dp[i - 1][0], time0), 1), 1};
            for (int j = 1; j < dp[i].length; j++) {
                long[] time = {dist[i - 1], speed};
                long[] a = new long[]{divide(add(dp[i - 1][j], time), 1), 1};
                long[] b = add(dp[i - 1][j - 1], time);
                if ((double) a[0] / a[1] < (double) b[0] / b[1]) {
                    dp[i][j] = a;
                } else {
                    dp[i][j] = b;
                }
            }
        }
        for (long[][] arr : dp) {
            double[] doubleArr = new double[arr.length];
            for (int i = 0; i < doubleArr.length; i++) {
                doubleArr[i] = (double) arr[i][0] / arr[i][1];
            }
            System.out.println(Arrays.toString(doubleArr));
        }
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[dp.length - 1][j][0] >= 0) {
                if ((double) dp[dp.length - 1][j][0] / dp[dp.length - 1][j][1] <= hoursBefore) {
                    return j;
                }
            }
        }
        return -1;
    }

    private static long[] add(long[] a, long[] b) {
        if (a[0] < 0 || b[0] < 0) {
            return new long[]{-1, 1};
        }
        long up = a[0] * b[1] + a[1] * b[0];
        if (up % a[1] == 0) {
            return new long[]{up / a[1], b[1]};
        } else if (up % b[1] == 0) {
            return new long[]{up / b[1], a[1]};
        } else {
            return new long[]{up, a[1] * b[1]};
        }
    }

    private static long divide(long[] value, long add) {
        if (value[0] < 0) {
            return -1;
        }
        if (value[0] % value[1] == 0) {
            return value[0] / value[1];
        } else {
            return value[0] / value[1] + add;
        }
    }
//    public static int minSkips(int[] dist, int speed, int hoursBefore) {
//        int[][][] dp = new int[dist.length + 1][dist.length][dist.length];
//        int[][] position = new int[dist.length][dist.length]; // key
//        for (int i = 0; i < position.length; i++) {
//            for (int j = i; j < position[0].length; j++) {
//                position[i][j] = i * dist.length + j;
//            }
//        }
//        Map<Integer, Integer> distanceMap = new HashMap<>();
//        for (int i = 0; i < position.length; i++) {
//            distanceMap.put(position[i][i], dist[i]);
//            for (int j = i + 1; j < position[0].length; j++) {
//                distanceMap.put(position[i][j], dist[j] + distanceMap.get(position[i][j - 1]));
//            }
//        }
//        dp[0][0][0] = 0;
//        for (int i = 1; i < dp.length; i++) {
//            dp[i][0][0] = dp[i - 1][0][0] + time(dist[i - 1], speed);
//            for (int j = 1; j < i; j++) {
//                for (int k = 0; k < i; k++) {
//                    dp[i][j][0] = Math.min(dp[i - 1][j][k] + time(dist[i - 1], speed), dp[i][j][0]);
//                }
//                for (int k = 1; k <= j; k++) {
//                    dp[i][j][k] = dp[i - 1][j - 1][k - 1]
//                            + time(distanceMap.get(position[i - k - 1][i - 1]), speed)
//                            - time(distanceMap.get(position[i - k - 1][i - 2]), speed);
//                }
//            }
//        }
//        for (int j = 0; j < dp[dist.length].length; j++) {
//            for (int k = 0; k <= j; k++) {
//                if (dp[dist.length][j][k] <= hoursBefore) {
//                    return j;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public static int time(int distance, int speed) {
//        int time = distance / speed;
//        return distance == speed * time ? time : time + 1;
//    }

}
