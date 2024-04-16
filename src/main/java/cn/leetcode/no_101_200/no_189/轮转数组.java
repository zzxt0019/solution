package cn.leetcode.no_101_200.no_189;

import java.util.Arrays;

public class 轮转数组 {
    public static void main(String[] args) {
        int[] arr = create(27);
        System.out.println(Arrays.toString(arr));
        rotate(arr, 38);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] create(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void rotate(int[] nums, int k) {
        rotate(nums, 0, nums.length, k);
    }

    private static void rotate(int[] nums, int start, int length, int k) {
        System.out.println(start + " " + length + " " + k);
        if (length <= 1 || k % length == 0) {
            return;
        }
        k = k % length;
        int count = 0;
        int num = 0;
        int i = 0;
        out:
        while (true) {
            for (i = 0; i < k; i++) {
                swap(nums, i, i + k + num * k, start, length);
                System.out.println(Arrays.toString(nums));
                count++;
                if (count >= length - length % k) {
                    break out;
                }
            }
            num++;
        }
        System.out.println(i);
        if (length % k == 0) {
            return;
        }
        rotate(nums, start + k - length % k, length % k, k % (length % k));
    }

    private static void swap(int[] nums, int i, int j, int start, int length) {
        if (i < 0) {
            i += length;
        }
        if (j < 0) {
            j += length;
        }
        int temp = nums[start + i % length];
        nums[start + i % length] = nums[start + j % length];
        nums[start + j % length] = temp;
    }
}
