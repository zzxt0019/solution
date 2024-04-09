package cn.leetcode.no_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 0, 4);
    }

    private static List<List<Integer>> nSum(int[] nums, long target, int start, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (n == 2) {
            return twoSum(nums, target, start);
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> subList = nSum(nums, target - nums[i], i + 1, n - 1);
                for (List<Integer> list : subList) {
                    list.add(nums[i]);
                }
                resultList.addAll(subList);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return resultList;
    }

    private static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> resultList = new ArrayList<>();
        while (left < right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            long sum = leftValue + rightValue;
            if (sum > target) {
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(leftValue);
                result.add(rightValue);
                resultList.add(result);
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            }
        }
        return resultList;
    }

}
