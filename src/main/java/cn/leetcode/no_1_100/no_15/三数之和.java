package cn.leetcode.no_1_100.no_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subList = twoSum(nums, -nums[i], i + 1);
            for (List<Integer> list : subList) {
                list.add(nums[i]);
            }
            resultList.addAll(subList);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return resultList;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> resultList = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            int sum = leftValue + rightValue;
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
                left++;
                right--;
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
            }
        }
        return resultList;
    }
}
