package cn.leetcode.no_301_400.no_377;

import java.util.Arrays;

public class 组合总和IV {
    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(combinationSum4(arr, 4));

    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
