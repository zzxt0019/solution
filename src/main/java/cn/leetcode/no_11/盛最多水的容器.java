package cn.leetcode.no_11;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        while (left < right) {
            total = Math.max(total, total(height, left, right));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return total;
    }

    private static int total(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * Math.abs(left - right);
    }
}
