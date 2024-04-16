package cn.leetcode.no_501_600.no_560;

public class 和为K的子数组 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == k) {
                count++;
            }
        }
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
