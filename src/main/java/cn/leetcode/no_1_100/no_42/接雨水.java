package cn.leetcode.no_1_100.no_42;

public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

    }

    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int top = Math.min(left[i - 1], right[i + 1]);
            if (top > height[i]) {
                total += top - height[i];
            }
        }
        return total;
    }
}
