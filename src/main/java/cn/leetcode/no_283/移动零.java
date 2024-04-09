package cn.leetcode.no_283;

import java.util.Arrays;

public class 移动零 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {2, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != zeroIndex) {
                    moveTo(nums, i, zeroIndex);
                }
                zeroIndex++;
            }
        }
    }

    private static void moveTo(int[] nums, int i, int j) {
        nums[j] = nums[i];
        nums[i] = 0;
    }
}
